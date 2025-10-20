package xtext.json.export;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import xtext.json.workflowDSL.*;

/**
 * Service for exporting WorkflowDSL models to JSON format with EXACT structure
 */
public class WorkflowJsonExporter {
    
    private final Gson gson;
    private int nodeIdCounter = 1;
    private Map<String, Integer> stepIdMap = new HashMap<>();
    
    public WorkflowJsonExporter() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    /**
     * Exports a Workflow model to JSON string with exact format
     */
    public String exportToJson(Workflow workflow) {
        JsonObject root = new JsonObject();
        JsonArray nodes = new JsonArray();
        JsonArray connections = new JsonArray();
        
        // Add data source as first node if present
        if (workflow.getSource() != null) {
            JsonObject sourceNode = createDataSourceNode(workflow.getSource());
            nodes.add(sourceNode);
        }
        
        // Process workflow steps
        if (workflow.getBody() != null && workflow.getBody().getSteps() != null) {
            List<Step> steps = workflow.getBody().getSteps();
            
            // Create nodes for each step
            for (Step step : steps) {
                JsonObject node = createNodeFromStep(step);
                nodes.add(node);
            }
            
            // Create connections
            createConnections(workflow, connections);
        }
        
        root.add("nodes", nodes);
        root.add("connections", connections);
        
        return gson.toJson(root);
    }
    
    private JsonObject createDataSourceNode(DataSource dataSource) {
        JsonObject node = new JsonObject();
        int nodeId = nodeIdCounter++;
        stepIdMap.put("data_source", nodeId);
        
        node.addProperty("id", nodeId);
        
        DataReader reader = dataSource.getReader();
        if (reader instanceof CSVReader) {
            node.addProperty("node_name", "CSV Reader");
            node.addProperty("node_type", "org.knime.base.node.io.filehandling.csv.reader.CSVTableReaderNodeFactory");
            
            JsonObject parameters = new JsonObject();
            CSVReader csvReader = (CSVReader) reader;
            if (csvReader.getFilePath() != null) {
                parameters.addProperty("file_path", csvReader.getFilePath().getPath());
            }
            if (csvReader.getDelimiter() != null) {
                parameters.addProperty("column_delimiter", getDelimiterValue(csvReader.getDelimiter()));
            } else {
                parameters.addProperty("column_delimiter", ",");
            }
            node.add("parameters", parameters);
            
        } else if (reader instanceof FileReader) {
            node.addProperty("node_name", "File Reader");
            node.addProperty("node_type", "org.knime.base.node.io.filehandling.csv.reader.FileReaderNodeFactory");
            
            JsonObject parameters = new JsonObject();
            FileReader fileReader = (FileReader) reader;
            if (fileReader.getFilePath() != null) {
                parameters.addProperty("file_path", fileReader.getFilePath().getPath());
            }
            node.add("parameters", parameters);
        }
        
        return node;
    }
    
    private String getDelimiterValue(Delimiter delimiter) {
        if (delimiter.getValue() != null) {
            return delimiter.getValue();
        }
        // Return the literal delimiter based on the grammar
        return ","; // Default
    }
    
    private JsonObject createNodeFromStep(Step step) {
        JsonObject node = new JsonObject();
        int nodeId = nodeIdCounter++;
        stepIdMap.put(step.getName(), nodeId);
        
        node.addProperty("id", nodeId);
        
        Transformation transformation = step.getTransformation();
        if (transformation != null) {
            setNodeNameAndType(transformation, node);
            JsonObject parameters = createParametersFromTransformation(transformation);
            node.add("parameters", parameters);
        } else {
            node.addProperty("node_name", step.getName());
            node.addProperty("node_type", "org.knime.base.node.generic.GenericNodeFactory");
            node.add("parameters", new JsonObject());
        }
        
        // Add contracts if present
        if (step.getContracts() != null) {
            JsonObject contracts = createContractsFromStep(step);
            node.add("contracts", contracts);
        }
        
        return node;
    }
    
    private void setNodeNameAndType(Transformation transformation, JsonObject node) {
        if (transformation instanceof RowFilter) {
            node.addProperty("node_name", "Row Filter");
            node.addProperty("node_type", "org.knime.base.node.preproc.filter.row.RowFilterNodeFactory");
        } else if (transformation instanceof ColumnFilter) {
            node.addProperty("node_name", "Column Filter");
            node.addProperty("node_type", "org.knime.base.node.preproc.filter.column.DataColumnSpecFilterNodeFactory");
        } else if (transformation instanceof TypeConversion) {
            node.addProperty("node_name", "String to Number");
            node.addProperty("node_type", "org.knime.base.node.preproc.colconvert.stringtonumber2.StringToNumber2NodeFactory");
        } else if (transformation instanceof Mapping) {
            node.addProperty("node_name", "Rule Engine");
            node.addProperty("node_type", "org.knime.base.node.rules.engine.RuleEngineNodeFactory");
        } else if (transformation instanceof Binner) {
            node.addProperty("node_name", "Numeric Binner");
            node.addProperty("node_type", "org.knime.base.node.preproc.binner.BinnerNodeFactory");
        } else if (transformation instanceof Imputation) {
            node.addProperty("node_name", "Missing Value");
            node.addProperty("node_type", "org.knime.base.node.preproc.pmml.missingval.MissingValueHandlerNodeFactory");
        } else if (transformation instanceof OutlierTreatment) {
            node.addProperty("node_name", "Numeric Outliers");
            node.addProperty("node_type", "org.knime.base.node.stats.outlier.handler.NumericOutliersNodeFactory");
        } else {
            node.addProperty("node_name", "Generic Node");
            node.addProperty("node_type", "org.knime.base.node.generic.GenericNodeFactory");
        }
    }
    
    private JsonObject createParametersFromTransformation(Transformation transformation) {
        JsonObject parameters = new JsonObject();
        
        if (transformation instanceof RowFilter) {
            createRowFilterParameters((RowFilter) transformation, parameters);
        } else if (transformation instanceof ColumnFilter) {
            createColumnFilterParameters((ColumnFilter) transformation, parameters);
        } else if (transformation instanceof TypeConversion) {
            createTypeConversionParameters((TypeConversion) transformation, parameters);
        } else if (transformation instanceof Mapping) {
            createMappingParameters((Mapping) transformation, parameters);
        } else if (transformation instanceof Binner) {
            createBinnerParameters((Binner) transformation, parameters);
        } else if (transformation instanceof Imputation) {
            createImputationParameters((Imputation) transformation, parameters);
        } else if (transformation instanceof OutlierTreatment) {
            createOutlierTreatmentParameters((OutlierTreatment) transformation, parameters);
        }
        
        return parameters;
    }
    
    private void createRowFilterParameters(RowFilter rowFilter, JsonObject parameters) {
        FilterCondition condition = rowFilter.getCondition();
        
        if (condition instanceof MissingFilter) {
            parameters.addProperty("filter_type", "MissingVal_RowFilter");
            parameters.addProperty("filter_type_inclusion", "INCLUDE");
            
            MissingFilter mf = (MissingFilter) condition;
            JsonArray inColumns = new JsonArray();
            JsonArray outColumns = new JsonArray();
            
            if (mf.getColumns() != null && mf.getColumns().getColumns() != null) {
                for (Column column : mf.getColumns().getColumns()) {
                    JsonObject columnInfo = new JsonObject();
                    columnInfo.addProperty("column_name", column.getName());
                    columnInfo.addProperty("column_type", "xstring");
                    inColumns.add(columnInfo);
                    outColumns.add(columnInfo);
                }
            }
            
            parameters.add("in_columns", inColumns);
            parameters.add("out_columns", outColumns);
            
        } else if (condition instanceof RangeFilter) {
            RangeFilter rf = (RangeFilter) condition;
            parameters.addProperty("filter_type", "RangeVal_RowFilter");
            
            RangeBounds bounds = rf.getBounds();
            if (bounds != null) {
                if (bounds.getLower() != null && bounds.getLower().getValue() != null) {
                    try {
                        double lowerValue = Double.parseDouble(bounds.getLower().getValue());
                        parameters.addProperty("lower_bound", lowerValue);
                        parameters.addProperty("has_lower_bound", true);
                    } catch (NumberFormatException e) {
                        parameters.addProperty("lower_bound", 0.0);
                        parameters.addProperty("has_lower_bound", true);
                    }
                }
                if (bounds.getUpper() != null && bounds.getUpper().getValue() != null) {
                    try {
                        double upperValue = Double.parseDouble(bounds.getUpper().getValue());
                        parameters.addProperty("upper_bound", upperValue);
                        parameters.addProperty("has_upper_bound", true);
                    } catch (NumberFormatException e) {
                        parameters.addProperty("upper_bound", 1000000000.0);
                        parameters.addProperty("has_upper_bound", false);
                    }
                }
            }
            
            String inclusion = rf.getIncludeExclude();
            parameters.addProperty("filter_type_inclusion", "include".equals(inclusion) ? "INCLUDE" : "EXCLUDE");
            
            // Add column information
            if (rf.getColumn() != null) {
                JsonArray inColumns = new JsonArray();
                JsonArray outColumns = new JsonArray();
                JsonObject columnInfo = new JsonObject();
                columnInfo.addProperty("column_name", rf.getColumn().getName());
                columnInfo.addProperty("column_type", "xstring");
                inColumns.add(columnInfo);
                outColumns.add(columnInfo);
                parameters.add("in_columns", inColumns);
                parameters.add("out_columns", outColumns);
            }
        }
    }
    
    private void createColumnFilterParameters(ColumnFilter columnFilter, JsonObject parameters) {
        JsonArray inColumns = new JsonArray();
        JsonArray outColumns = new JsonArray();
        
        if (columnFilter.getColumns() != null && columnFilter.getColumns().getColumns() != null) {
            for (Column column : columnFilter.getColumns().getColumns()) {
                JsonObject columnInfo = new JsonObject();
                columnInfo.addProperty("column_name", column.getName());
                columnInfo.addProperty("column_type", "xstring");
                inColumns.add(columnInfo);
            }
        }
        
        parameters.add("in_columns", inColumns);
        parameters.add("out_columns", outColumns);
    }
    
    private void createTypeConversionParameters(TypeConversion typeConversion, JsonObject parameters) {
        JsonArray inColumns = new JsonArray();
        JsonArray outColumns = new JsonArray();
        
        if (typeConversion.getColumns() != null && typeConversion.getColumns().getColumns() != null) {
            for (Column column : typeConversion.getColumns().getColumns()) {
                JsonObject columnInfo = new JsonObject();
                columnInfo.addProperty("column_name", column.getName());
                columnInfo.addProperty("column_type", "xstring");
                inColumns.add(columnInfo);
                outColumns.add(columnInfo);
            }
        }
        
        parameters.addProperty("decimal_separator", ".");
        parameters.add("in_columns", inColumns);
        parameters.add("out_columns", outColumns);
    }
    
    private void createMappingParameters(Mapping mapping, JsonObject parameters) {
        if (mapping instanceof ValueMapping) {
            ValueMapping vm = (ValueMapping) mapping;
            
            JsonArray rules = new JsonArray();
            JsonArray functionTypes = new JsonArray();
            JsonArray mappingParams = new JsonArray();
            
            if (vm.getRules() != null && vm.getRules().getRules() != null) {
                for (MappingRule rule : vm.getRules().getRules()) {
                    if (rule.getFrom() != null && rule.getTo() != null) {
                        String ruleStr = "$" + vm.getColumn().getName() + "$ LIKE \"*" + rule.getFrom() + "*\" => \"" + rule.getTo() + "\"";
                        rules.add(ruleStr);
                        functionTypes.add("LIKE");
                        
                        JsonObject mappingParam = new JsonObject();
                        mappingParam.addProperty("key", rule.getFrom());
                        mappingParam.addProperty("value", rule.getTo());
                        mappingParams.add(mappingParam);
                    }
                }
            }
            
            rules.add("TRUE => $" + vm.getColumn().getName() + "$");
            
            parameters.add("rules", rules);
            parameters.add("function_types", functionTypes);
            parameters.addProperty("new_column_name", "prediction");
            parameters.addProperty("replace_column_name", vm.getColumn().getName());
            parameters.addProperty("append_column", false);
            
            // Column information
            JsonArray inColumns = new JsonArray();
            JsonArray outColumns = new JsonArray();
            
            JsonObject inColumnInfo = new JsonObject();
            inColumnInfo.addProperty("column_name", vm.getColumn().getName());
            inColumnInfo.addProperty("column_type", "xstring");
            inColumns.add(inColumnInfo);
            
            JsonObject outColumnInfo = new JsonObject();
            outColumnInfo.addProperty("column_name", "prediction");
            outColumnInfo.addProperty("column_type", "xstring");
            outColumns.add(outColumnInfo);
            
            parameters.add("in_columns", inColumns);
            parameters.add("out_columns", outColumns);
            
            // Mapping object
            JsonObject mappingObj = new JsonObject();
            mappingObj.addProperty("replace_column_name", vm.getColumn().getName());
            mappingObj.add("mapping_parameters", mappingParams);
            mappingObj.addProperty("map_operation", "VALUE_MAPPING");
            mappingObj.addProperty("unique_replacement_one_column", false);
            parameters.add("mapping", mappingObj);
        }
    }
    
    private void createBinnerParameters(Binner binner, JsonObject parameters) {
        JsonArray bins = new JsonArray();
        
        if (binner.getDefinitions() != null && binner.getDefinitions().getDefinitions() != null) {
            for (BinDef binDef : binner.getDefinitions().getDefinitions()) {
                JsonObject bin = new JsonObject();
                bin.addProperty("binName", binDef.getName().getName());
                
                Interval interval = binDef.getInterval();
                if (interval != null) {
                    bin.addProperty("closureType", "openClosed");
                    bin.addProperty("leftMargin", getIntervalBoundValue(interval.getLower()));
                    bin.addProperty("rightMargin", getIntervalBoundValue(interval.getUpper()));
                }
                
                bins.add(bin);
            }
        }
        
        parameters.add("bins", bins);
        
        // Column information
        if (binner.getColumn() != null) {
            JsonArray inColumns = new JsonArray();
            JsonArray outColumns = new JsonArray();
            
            JsonObject inColumnInfo = new JsonObject();
            inColumnInfo.addProperty("column_name", binner.getColumn().getName());
            inColumnInfo.addProperty("column_type", "xstring");
            inColumns.add(inColumnInfo);
            
            String outputColumnName = binner.getColumn().getName() + "_binned";
            JsonObject outColumnInfo = new JsonObject();
            outColumnInfo.addProperty("column_name", outputColumnName);
            outColumnInfo.addProperty("column_type", "xstring");
            outColumns.add(outColumnInfo);
            
            parameters.add("in_columns", inColumns);
            parameters.add("out_columns", outColumns);
        }
    }
    
    private void createImputationParameters(Imputation imputation, JsonObject parameters) {
        JsonArray inColumns = new JsonArray();
        JsonArray outColumns = new JsonArray();
        
        if (imputation.getColumns() != null && imputation.getColumns().getColumns() != null) {
            for (Column column : imputation.getColumns().getColumns()) {
                JsonObject columnInfo = new JsonObject();
                columnInfo.addProperty("column_name", column.getName());
                columnInfo.addProperty("column_type", "xstring");
                inColumns.add(columnInfo);
                outColumns.add(columnInfo);
            }
        }
        
        ImputeMethod method = imputation.getMethod();
        if (method instanceof FixedImpute) {
            parameters.addProperty("imputationType", "Fixed Value");
            JsonArray fixedValues = new JsonArray();
            fixedValues.add("Unknown");
            parameters.add("fixStringValues", fixedValues);
        } else {
            parameters.addProperty("imputationType", "MostFrequent");
            JsonArray fixedValues = new JsonArray();
            fixedValues.add((String) null);
            parameters.add("fixStringValues", fixedValues);
        }
        
        parameters.add("in_columns", inColumns);
        parameters.add("out_columns", outColumns);
    }
    
    private void createOutlierTreatmentParameters(OutlierTreatment outlierTreatment, JsonObject parameters) {
        JsonArray inColumns = new JsonArray();
        JsonArray outColumns = new JsonArray();
        
        if (outlierTreatment.getColumns() != null && outlierTreatment.getColumns().getColumns() != null) {
            for (Column column : outlierTreatment.getColumns().getColumns()) {
                JsonObject columnInfo = new JsonObject();
                columnInfo.addProperty("column_name", column.getName());
                columnInfo.addProperty("column_type", "xstring");
                inColumns.add(columnInfo);
                outColumns.add(columnInfo);
            }
        }
        
        parameters.addProperty("estimation_type", "R_4");
        parameters.addProperty("iqr_scalar", 1.5);
        parameters.addProperty("replacement_strategy", "Closest permitted value");
        parameters.addProperty("outlier_treatment", "Replace outlier values");
        parameters.addProperty("detection_option", "All outliers");
        
        parameters.add("in_columns", inColumns);
        parameters.add("out_columns", outColumns);
    }
    
    private void createConnections(Workflow workflow, JsonArray connections) {
        if (workflow.getBody() != null && workflow.getBody().getSteps() != null) {
            List<Step> steps = workflow.getBody().getSteps();
            
            // Connect data source to the first step that doesn't have a specific target
            // or to the step that targets "data" 
            if (stepIdMap.containsKey("data_source")) {
                Integer sourceId = stepIdMap.get("data_source");
                
                // Find the step that should connect to data source
                for (Step step : steps) {
                    if (step.getTarget() != null && step.getTarget().equals("data")) {
                        Integer destId = stepIdMap.get(step.getName());
                        if (destId != null) {
                            JsonObject connection = new JsonObject();
                            connection.addProperty("sourceID", sourceId);
                            connection.addProperty("destID", destId);
                            connections.add(connection);
                            break;
                        }
                    }
                }
                
                // If no step targets "data", connect to first step
                if (connections.size() == 0 && !steps.isEmpty()) {
                    Integer destId = stepIdMap.get(steps.get(0).getName());
                    if (destId != null) {
                        JsonObject connection = new JsonObject();
                        connection.addProperty("sourceID", sourceId);
                        connection.addProperty("destID", destId);
                        connections.add(connection);
                    }
                }
            }
            
            // Connect steps based on their target references
            // If step B targets step A, then A connects TO B
            for (Step currentStep : steps) {
                if (currentStep.getTarget() != null && !currentStep.getTarget().equals("data")) {
                    String targetStepName = currentStep.getTarget();
                    Integer sourceId = stepIdMap.get(targetStepName);
                    Integer destId = stepIdMap.get(currentStep.getName());
                    
                    if (sourceId != null && destId != null) {
                        JsonObject connection = new JsonObject();
                        connection.addProperty("sourceID", sourceId);
                        connection.addProperty("destID", destId);
                        connections.add(connection);
                    }
                }
            }
        }
    }
    
    private String getIntervalBoundValue(BoundValue bound) {
        if (bound == null) return "0.0";
        if (bound.getValue() != null) {
            return bound.getValue();
        }
        return "Infinity";
    }
    
    private String getIntervalBoundValue(IntervalBound bound) {
        if (bound == null) return "0.0";
        if (bound.getValue() != null) {
            return bound.getValue();
        }
        return "Infinity";
    }
    
    private JsonObject createContractsFromStep(Step step) {
        JsonObject contractsObj = new JsonObject();
        
        if (step.getContracts() != null && step.getContracts().getContracts() != null) {
            JsonArray preconditions = new JsonArray();
            JsonArray postconditions = new JsonArray();
            JsonArray invariants = new JsonArray();
            
            for (Contract contract : step.getContracts().getContracts()) {
                JsonObject contractJson = new JsonObject();
                
                if (contract instanceof Precondition) {
                    Precondition pre = (Precondition) contract;
                    contractJson.addProperty("name", getContractName(pre.getName()));
                    contractJson.add("body", createContractBodyJson(pre.getBody()));
                    preconditions.add(contractJson);
                    
                } else if (contract instanceof Postcondition) {
                    Postcondition post = (Postcondition) contract;
                    contractJson.addProperty("name", getContractName(post.getName()));
                    contractJson.add("body", createContractBodyJson(post.getBody()));
                    postconditions.add(contractJson);
                    
                } else if (contract instanceof Invariant) {
                    Invariant inv = (Invariant) contract;
                    contractJson.addProperty("name", getContractName(inv.getName()));
                    contractJson.add("body", createContractBodyJson(inv.getBody()));
                    invariants.add(contractJson);
                }
            }
            
            if (preconditions.size() > 0) {
                contractsObj.add("preconditions", preconditions);
            }
            if (postconditions.size() > 0) {
                contractsObj.add("postconditions", postconditions);
            }
            if (invariants.size() > 0) {
                contractsObj.add("invariants", invariants);
            }
        }
        
        return contractsObj;
    }
    
    private String getContractName(ContractName contractName) {
        if (contractName.getName() != null) {
            return contractName.getName();
        }
        return "unnamed_contract";
    }
    
    private JsonObject createContractBodyJson(ContractBody body) {
        JsonObject bodyJson = new JsonObject();
        
        if (body.getType() instanceof ValueRangeContract) {
            ValueRangeContract vrc = (ValueRangeContract) body.getType();
            bodyJson.addProperty("type", "value_range");
            bodyJson.add("field", createContractFieldJson(vrc.getField()));
            bodyJson.add("value", createContractValueJson(vrc.getValue()));
            
        } else if (body.getType() instanceof ConditionContract) {
            ConditionContract cc = (ConditionContract) body.getType();
            bodyJson.addProperty("type", "condition");
            bodyJson.add("if_clause", createIfClauseJson(cc.getIfClause()));
            bodyJson.add("then_clause", createThenClauseJson(cc.getThenClause()));
            
        } else if (body.getType() instanceof SpecialValueContract) {
            SpecialValueContract svc = (SpecialValueContract) body.getType();
            bodyJson.addProperty("type", "special_value");
            bodyJson.add("field", createContractFieldJson(svc.getField()));
            // Determine if it's "no_special_values" or "has_special_values" based on the contract structure
            bodyJson.addProperty("check_type", "no_special_values"); // This would need more logic based on actual contract
            
        } else if (body.getType() instanceof CastTypeContract) {
            CastTypeContract ctc = (CastTypeContract) body.getType();
            bodyJson.addProperty("type", "cast_type");
            bodyJson.add("field", createContractFieldJson(ctc.getField()));
            bodyJson.addProperty("target_type", ctc.getType());
            // Determine if it's "castable_to" or "is_type" based on the contract structure
            bodyJson.addProperty("check_type", "castable_to"); // This would need more logic based on actual contract
        }
        
        return bodyJson;
    }
    
    private JsonObject createContractFieldJson(ContractField field) {
        JsonObject fieldJson = new JsonObject();
        
        if (field.getColumn() != null) {
            fieldJson.addProperty("column", field.getColumn().getName());
        }
        
        // Determine if it's input or output field based on the grammar structure
        // This would need to be implemented based on the actual field type in the grammar
        fieldJson.addProperty("scope", "input"); // Default, would need proper detection
        
        return fieldJson;
    }
    
    private JsonObject createContractValueJson(ContractValue value) {
        JsonObject valueJson = new JsonObject();
        
        if (value.getType() != null) {
            valueJson.addProperty("constraint_type", "castable_to");
            valueJson.addProperty("type", value.getType());
            
        } else if (value.getBounds() != null) {
            valueJson.addProperty("constraint_type", "in_range");
            valueJson.add("bounds", createRangeBoundsJson(value.getBounds()));
            
        } else if (value.getValue() != null) {
            valueJson.addProperty("constraint_type", "matches");
            valueJson.add("value", createValueJson(value.getValue()));
        }
        
        return valueJson;
    }
    
    private JsonObject createRangeBoundsJson(RangeBounds bounds) {
        JsonObject boundsJson = new JsonObject();
        
        if (bounds.getLower() != null) {
            boundsJson.addProperty("lower", getIntervalBoundValue(bounds.getLower()));
        }
        if (bounds.getUpper() != null) {
            boundsJson.addProperty("upper", getIntervalBoundValue(bounds.getUpper()));
        }
        
        return boundsJson;
    }
    
    private JsonObject createValueJson(Value value) {
        JsonObject valueJson = new JsonObject();
        
        if (value.getString() != null) {
            valueJson.addProperty("string_value", value.getString());
        } else if (value.getNumber() != null) {
            valueJson.addProperty("number_value", value.getNumber());
        }
        
        return valueJson;
    }
    
    private JsonObject createIfClauseJson(IfClause ifClause) {
        JsonObject ifJson = new JsonObject();
        // Add implementation based on your grammar structure
        ifJson.addProperty("condition_type", "generic");
        return ifJson;
    }
    
    private JsonObject createThenClauseJson(ThenClause thenClause) {
        JsonObject thenJson = new JsonObject();
        // Add implementation based on your grammar structure  
        thenJson.addProperty("action_type", "generic");
        return thenJson;
    }
}