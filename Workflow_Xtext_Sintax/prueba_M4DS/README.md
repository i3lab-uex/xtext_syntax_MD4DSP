
# MM-M4DSP - Metamodels, Validation library, Models and Code Generation

This repository includes an Eclipse Modeling Framework (EMF) project with the metamodels ContractDef, Library, Environment, Workflow and Contract designs, the validation library specification with different transformations available and its associated contracts. It also includes some models that comply with the Workflow metamodel, which includes the perspective or conceptual model (Workflow), as well as the operational model (Environment).

Additionally, the project contains an Acceleo project, embedded in the root directory, to generate code from the current Eclipse Modeling Framework project.


## Eclipse EMF Configuration

To use this project properly, you must follow the next steps:

- Clone this EMF project to your Eclipse Modeling Framework (EMF) IDE. If you are not able to clone it with Eclipse, 
  you can just download the project from [MM-M4DS](https://github.com/i3uex/MM-M4DS) and import it with Eclipse IDE 
  by selecting "File" → "Import..." → "Existing projects into workspace" → "Select archive file" and choosing the 
  corresponding zip file with the downloaded project.


- After importing the project, you must copy the mapped model to the `model` directory and remove residual DataProcessing,
  Links, and Files related to non-existing nodes in the `library_validation.xmi` file.

## Acceleo Project Configuration

To use the code generation capabilities of Acceleo with this project, follow these steps to properly set up and execute the code generation process:

- Open Eclipse IDE and create the Acceleo Project in Eclipse, by going to File → New → Project...

- Choose Acceleo Project and click Next.

- Set the Project name to Acceleo.MM_M4DS and click Next.

- In the Metamodel URIs field, click in the `+` button, browse in the `Runtime Version` and select the URIs from the .ecore metamodels (Workflow, Library, ContractDef, Contract, and Environment).

- In Type, select Library.

- In the template section check the options: "Generate documentation" "Generate file" and "Main template."

- Leave the default values for other fields and click Finish. This will create a working Acceleo project structure with a src directory containing a sample .mtl file.

- Replace the bin, src, and META-INF folders with the ones from the existing Acceleo.MM_M4DS/src directory of the repository.

- Ensure that the directory structure (i.e., the package structure) is preserved.

- If prompted by Eclipse, refresh the project (right-click on the project and select Refresh or press F5).

- Once the templates are in place, and the project is configured, to generate code from the model located in `prueba_M4DS` project, right-click on the main .mtl file (located at `Acceleo.MM_M4DS/src/Acceleo/MM_M4DS_Workflow/main/generate.mtl`) in the src folder.

- Select Run As → Run Configurations... and create a new Acceleo Application configuration.

- In the Project field, select the Acceleo.MM_M4DS project.

- In the Main class field, select the main .mtl file (`Acceleo.MM_M4DS_Workflow.main`).

- In the Model field, click Browse Workspace and select the desired .xmi model file from the model/ directory (e.g., wf_validation_KNIME_contracts.xmi).

- In the Target field, choose or create a destination folder (e.g., Acceleo.MM_M4DS/Generated/) where the generated code will be placed.

- Click Run to execute the code generation. After waiting for the process to complete, you should see the generated code in the specified target directory.

When the code generation is completed, you will find six files in the `generated_code` directory:
- `deploy_docker_app.sh`: A script to deploy the contract validation application in a Docker container.
- `Dockerfile`: A Dockerfile to build the Docker image for the contract validation application using a [Python 3.11-slim](https://hub.docker.com/layers/library/python/3.11-slim/images/sha256-1591aa8c01b5b37ab31dbe5662c5bdcf40c2f1bce4ef1c1fd24802dae3d01052?context=explore) image as the base image a cloning the [Python contract validation library](https://github.com/i3uex/MD4DSP-m2python) repository.
- `workflow_scripts.sh`: A shell script that contains the application main process to convert dataDictionaries to the parquet unified data format and initialized the application menu.
- `fileFormatting.py`: A Python script that contains the file formatting functions to convert the dataDictionaries to the parquet unified data format.
- `contracts_Job_Model_data_set_with_metanode_KNIME_.py`: A Python script that contains the contract validation calls for the MD4DSP workflow (only contract validations).
- `dataProcessing_Job_Model_data_set_with_metanode_KNIME_.py`: A Python script that contains the data processing calls for the MD4DSP workflow (data transformations and contract validations).
- `transformations_Job_Model_data_set_with_metanode_KNIME_.py`: A Python script that contains the data transformations calls for the MD4DSP workflow (just data transformations).

## Project Structure
```bash
prueba_M4DS/
│
├── Acceleo.MM_M4DS/
│  ├── Generated/
│  ├── src/
│  └── ...
│
├── metamodel/
│  ├── images/
│  │  ├── /prueba_M4DS/metamodel/images/ContractDefinitionMM.png
│  │  ├── /prueba_M4DS/metamodel/images/ContractMM.png
│  │  ├── /prueba_M4DS/metamodel/images/Environment class diagram.png
│  │  ├── /prueba_M4DS/metamodel/images/LibraryMM.png
│  │  └── /prueba_M4DS/metamodel/images/WorkflowMM.png
│  │
│  ├── Contract.aird
│  ├── Contract.ecore
│  ├── ContractDef.aird
│  ├── ContractDef.ecore
│  ├── Environment.aird
│  ├── Environment.ecore
│  ├── Library.aird
│  ├── Library.ecore
│  ├── Workflow.aird
│  └── Workflow.ecore
│
├── model/
│  ├── knime_dataDictionaries/
│  │  └── ...
│  ├── python_dataDictionaries/
│  │  └── ...
│  ├── wf_validation_KNIME_contracts.xmi
│  ├── library_validation.xmi
│  ├── library_validation_job.xmi
│  └── ...
│
└── README.md
```

- **`Acceleo.MM_M4DS/`**: contains the Acceleo project to get generated code from models.
- **`Acceleo.MM_M4DS/Generated`**: folder from Acceleo project to store generated code files.
- **`Acceleo.MM_M4DS/src`**: source code files with Acceleo templates for code generation from models.


- **`metamodel/`**: contains the designed metamodels, stored in .ecore and .aird format. Open .aird files to see the metamodel as a class diagram (for a better visualization).
- **`metamodel/images`**: contains the designed metamodels but exported in png format.


- **`model/`**: contains the models created that comply with the Workflow metamodel. A model of this kind is `wf_validation_KNIME_contracts.xmi`. In addition, in this directory is stored the validation contract library (`wf_validation_library.xmi`).
- **`model/knime_dataDictionaries`**: contains the data exported from KNIME platform for the `wf_validation_KNIME_contracts` Workflow model.
- **`model/python_dataDictionaries`**: contains the data exported from Python platform for the `wf_validation_KNIME_contracts` Workflow model.
- 

- **`README.md`**: file that contains the documentation of the project.
  

## Authors

- [Francisco Javier Melchor González](https://www.github.com/franjmelchor)
- [Carlos Breuer Carrasco](https://www.github.com/carlosbc24)
- [Carlos Cambero Rojas](https://www.github.com/CCamberoR)


## Questions
If you have any questions, please contact any of the authors.
