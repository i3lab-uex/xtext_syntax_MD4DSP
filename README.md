# xtext_syntax_MD4DSP

## Description

This project implements a textual syntax for the MD4DSP metamodels (Workflow and Library) using Xtext and Xtend frameworks. It provides a Domain-Specific Language (DSL) that enables readable and maintainable textual representations of data processing workflows and libraries, complementing the existing graphical metamodels.

The textual syntax improves readability, expressiveness, and provides a concise representation of models, facilitating their editing and manipulation by domain specialists. The project leverages Xtext for grammar definition and automatic generation of parsers, semantic analyzers, validators, and editing environments, while Xtend enables automatic transformations from textual representations to executable artifacts.

## Prerequisites

- **Java Development Kit (JDK)**: Java 17 or higher (required by recent Xtext versions)
- **Eclipse IDE**: "Eclipse IDE for Java and DSL Developers" distribution (includes Xtext and Xtend support)

## Installation

1. **Install Java 17 JDK**:
   Ensure you have Java 17 or higher installed and configured in your system PATH.

2. **Install Eclipse IDE for Java and DSL Developers**:
   Download from the Eclipse Foundation website or install Xtext manually in an existing Eclipse installation:
   - In Eclipse: `Help → Eclipse Marketplace`
   - Search for "Xtext"
   - Select "Eclipse Xtext" and install all related components
   - Restart Eclipse when prompted

3. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/xtext_syntax_MD4DSP.git
   ```

4. **Import the project into Eclipse**:
   - Open Eclipse
   - `File → Import → General → Existing Projects into Workspace`
   - Select the cloned repository directory
   - Import all projects (xtext.MM_M4DS, xtext.MM_M4DS.ui, xtext.MM_M4DS.tests, etc.)

## Usage

### Generating Xtext Artifacts

1. **Generate the language infrastructure**:
   - Right-click on `src/xtext/MM_M4DS.xtext` in the main project
   - Select `Run As → Generate Xtext Artifacts`
   - Wait for the generation process to complete (check console for messages)

2. **Alternative**: Run the MWE2 workflow:
   - Right-click on `src/xtext/GenerateMM_M4DS.mwe2`
   - Select `Run As → MWE2 Workflow`

### Testing the Editor

1. **Launch runtime Eclipse**:
   - Right-click on the main project (`xtext.MM_M4DS`)
   - Select `Run As → Eclipse Application`
   - A new Eclipse instance will open with your DSL editor installed

2. **Create a test project**:
   - In the runtime Eclipse: `File → New → General → Project`
   - Create a new file with extension `.mm_m4ds`
   - Start writing your workflow or library definitions

### Example DSL Syntax

Create a file `example.mm_m4ds` with the workflow content you want to test, similar as the presented in `mm_m4ds.xtext_dsl/test.mm_m4ds` file.

## Project Structure

```
xtext_syntax_MD4DSP/
│
├── mm_m4ds.xtext_dsl/
│   └── test.mm_m4ds              # Example DSL file
│
├── xtext.MM_M4DS/                # Main Xtext project
│   ├── src/
│   │   └── xtext/
│   │       ├── MM_M4DS.xtext           # Grammar definition
│   │       ├── GenerateMM_M4DS.mwe2    # Workflow generator
│   │       ├── MM_M4DSRuntimeModule.java
│   │       ├── MM_M4DSStandaloneSetup.java
│   │       ├── formatting2/            # Code formatting
│   │       ├── generator/              # Code generators
│   │       ├── scoping/               # Name resolution
│   │       └── validation/            # Validation rules
│   │
│   ├── src-gen/                  # Generated artifacts
│   ├── model/
│   │   └── generated/
│   │       ├── MM_M4DS.ecore          # Ecore metamodel
│   │       └── MM_M4DS.genmodel       # EMF generator model
│   │
│   ├── META-INF/
│   └── build.properties
│
├── xtext.MM_M4DS.ide/           # IDE integration
├── xtext.MM_M4DS.tests/         # Language tests
├── xtext.MM_M4DS.ui/            # Eclipse UI plugin
├── xtext.MM_M4DS.ui.tests/      # UI tests
│
└── README.md
```

### Key Components

- **`MM_M4DS.xtext`**: Contains the complete grammar definition for Workflow and Library metamodels, including data fields, processing steps, contracts, and validation conditions.

- **`GenerateMM_M4DS.mwe2`**: Workflow configuration file that defines the generation process for parsers, validators, formatters, and Eclipse integration components.

- **`src-gen/`**: Contains automatically generated code including parsers, serializers, and model classes. This directory is regenerated each time you run the Xtext generator.

- **`model/generated/`**: Contains the Ecore metamodel and EMF generator model derived from the original MD4DSP metamodels.

- **IDE Projects**: Provide Eclipse integration, including syntax highlighting, content assist, validation, and other editor features.

## Grammar Features

The DSL supports the following main elements:

- **Workflows**: Define data processing pipelines with steps, data fields, and contracts
- **Libraries**: Define reusable transformations and jobs with parameters
- **Data Fields**: Support for Categorical, Continuous, and Date field types
- **Contracts**: Define validation conditions with comparison operators
- **Processing Steps**: Include PMML models and data processing operations

## Development

### Extending the Grammar

To modify the grammar:

1. Edit `src/xtext/MM_M4DS.xtext`
2. Run `Generate Xtext Artifacts`
3. Test changes in the runtime Eclipse instance

## Troubleshooting

- **Build errors**: Ensure all projects are properly imported and Java 17+ is configured
- **Generation failures**: Check that the `.genmodel` file is properly configured and all metamodels are accessible
- **Runtime issues**: Verify that the runtime Eclipse instance has the correct workspace and project structure

## Authors

- Carlos Breuer Carrasco
- Carlos Cambero Rojas

## Questions

If you have any questions about the implementation or usage of this textual syntax, please contact the authors or create an issue in the repository.
