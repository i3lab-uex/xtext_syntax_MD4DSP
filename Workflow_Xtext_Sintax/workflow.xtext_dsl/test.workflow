// Archivo: test.workflow

workflow join_example {
    
    environment local test_docker_refactor {
        path "./wf_validation_contracts"
        storage {
            localFolder dataset1 {
                folderPath "../knime_dataDictionaries"
                files {
                    file {
                        dataDictionary join(Name with City)_input_dataDictionary
                    }
                }
            }
        }
        containerName "docker-contracts"
        developmentTool {
            version "3.11"
            tool PYTHON
        }
        imageName "ubuntu-22.04"
        imageTag "latest"
    }

    dataprocessing {
        dataProcessing join(Name with City) {
            definition JoinTransformation
            origin_function "String Manipulation"

            inputPort {
                dataDictionary join(Name with City)_input_dataDictionary {
                    fileName "join_input_dataDictionary.csv"
                    datafields {
                        categorical join(Name)_input1_dataField {
                            displayName "name"
                            categoricalDef CatDef1
                        }
                        categorical join(City)_input2_dataField {
                            displayName "City"
                            categoricalDef CatDef2
                        }
                    }
                }
            }

            outputPort {
                dataDictionary join(Name with City)_output_dataDictionary {
                    fileName "join_output_dataDictionary.csv"
                    datafields {
                        categorical join(Name with City)_output_dataField {
                            displayName "Name with City"
                            categoricalDef CatDefOut
                        }
                    }
                }
            }

            parameters {
                join join(Name with City)_param_join {
                    operand field join(Name with City)_param_op1_field {
                        datafield join(Name)_input1_dataField
                    }
                    operand fixValue join(Name with City)_param_op2_fix_value {
                        value primitive join(Name with City)_param_op2_fix_value_primitive {
                            value "-"
                        }
                    }
                    operand field join(Name with City)_param_op3_field {
                        datafield join(City)_input2_dataField
                    }
                }

                derivedField derived_field(Name with City)_param_join {
                    der_dataField join(Name with City)_output_dataField
                }
            }

            contracts {
                contract join(Name with City)_join_INVARIANT {
                    contractDefinition JoinContractDef
                    contract contractElement { }
                }
            }
        }
    }
}
