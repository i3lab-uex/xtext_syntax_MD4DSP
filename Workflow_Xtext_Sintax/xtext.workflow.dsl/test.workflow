// Archivo: test.workflow

workflow join_example {
    
    dataprocessing {
        dataProcessing join_Name_with_City {
            definition JoinTransformation
            origin "String Manipulation"

            inputPort {
                dataDictionary input_data_dict {
                    dataDictionaryDefinition InputDataDictionaryDef
                    fileName "join_input_dataDictionary.csv"
                    datafields {
                        categorical join_Name_input1_dataField {
                            categoricalDef CatDef1
                            dataType String
                            displayName "name"
                        }
                        categorical join_City_input2_dataField {
                            categoricalDef CatDef2
                            dataType String
                            displayName "City"
                        }
                    }
                }
            }

            outputPort {
                dataDictionary output_data_dict {
                    dataDictionaryDefinition OutputDataDictionaryDef
                    fileName "join_output_dataDictionary.csv"
                    datafields {
                        categorical join_Name_with_City_output_dataField {
                            categoricalDef CatDefOut
                            dataType String
                            displayName "Name with City"
                        }
                    }
                }
            }

            parameters {
                primitive separator_primitive {
                    primitiveDef PrimitiveDef1
                    value "-"
                    dataType String
                }

                join join_operation {
                    joinDef JoinOperationDef
                    operands {
                        field name_field {
                            fieldDef FieldDef1
                            datafield join_Name_input1_dataField
                        }
                        fixValue separator_value {
                            fixValueDef FixValueDef1
                            value separator_primitive
                        }
                        field city_field {
                            fieldDef FieldDef2
                            datafield join_City_input2_dataField
                        }
                    }
                }

                derivedField output_derived_field {
                    derivedFieldDef DerivedFieldDef1
                    der_dataField join_Name_with_City_output_dataField
                }
            }

            contracts {
                contract join_invariant_contract {
                    contractDefinition JoinContractDef
                    contract contractElement { }
                }
            }
        }
    }
}