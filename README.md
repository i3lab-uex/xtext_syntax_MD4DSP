# WorkflowDSL - Complete Documentation

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Xtext](https://img.shields.io/badge/Xtext-2.40.0-orange.svg)](https://www.eclipse.org/Xtext/)
[![Eclipse](https://img.shields.io/badge/Eclipse-2023--06-blue.svg)](https://www.eclipse.org/)

## Table of Contents

1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Installation & Setup](#installation--setup)
4. [WorkflowDSL Grammar Guide](#workflowdsl-grammar-guide)
5. [Creating .wf Files](#creating-wf-files)
6. [Contract System](#contract-system)
7. [Transformations Reference](#transformations-reference)
8. [Code Generation](#code-generation)
9. [Examples](#examples)
10. [Troubleshooting](#troubleshooting)

---

## Project Overview

**WorkflowDSL** is a Domain-Specific Language (DSL) built with **Eclipse Xtext 2.40.0** for defining data processing workflows in a declarative, human-readable format. The project automatically generates KNIME-compatible JSON from `.wf` textual files.

### Key Features

- **Declarative Syntax**: Define complex data pipelines in a readable text format
- **Design by Contract**: Preconditions, postconditions, and invariants
- **Automatic Code Generation**: Generates KNIME-style JSON with nodes, connections, and contracts
- **Rich Transformations**: Imputation, filtering, mapping, binning, outlier detection, type conversion
- **Pipeline Composition**: Use `|>` operator to chain transformations
- **IDE Support**: Full Eclipse IDE integration with syntax highlighting, auto-completion, and validation

### Project Structure

```
xtext_syntax_MD4DSP/
├── xtext.json.WorkflowDSL/           # Core DSL plugin
│   ├── src/
│   │   └── xtext/json/
│   │       ├── WorkflowDSL.xtext     # Grammar definition
│   │       └── generator/
│   │           └── WorkflowDSLGenerator.xtend  # JSON generator
│   ├── src-gen/                      # Generated Xtext code
│   └── model/generated/
│       ├── WorkflowDSL.ecore         # Ecore metamodel
│       └── WorkflowDSL.genmodel      # EMF generator model
├── xtext.json.WorkflowDSL.ide/       # IDE support
├── xtext.json.WorkflowDSL.ui/        # Eclipse UI plugin
├── xtext.json.WorkflowDSL.tests/     # Unit tests
├── Workflow.json/                    # Example workflows
│   ├── modelDataSetWithMetanode.wf   # Example .wf file
│   └── src-gen/                      # Generated JSON output
└── README.md                         # This file
```

---

## Architecture

### Components

1. **Grammar Definition (`WorkflowDSL.xtext`)**
   - Defines the concrete syntax of the DSL
   - Specifies all language constructs, keywords, and rules
   - Uses EBNF-like notation

2. **Metamodel (`WorkflowDSL.ecore`)**
   - Abstract syntax representation (EMF/Ecore model)
   - Generated automatically from the grammar
   - Defines the AST (Abstract Syntax Tree) structure

3. **Code Generator (`WorkflowDSLGenerator.xtend`)**
   - Transforms `.wf` files into KNIME JSON format
   - Implements the visitor pattern to traverse the AST
   - Generates nodes, connections, and contracts sections

4. **IDE Support**
   - Syntax highlighting
   - Content assist (auto-completion)
   - Real-time validation
   - Error markers

### Data Flow

```
.wf File (textual) 
    ↓ [Xtext Parser]
AST (EMF Model)
    ↓ [WorkflowDSLGenerator.xtend]
JSON Output (KNIME format)
```

---

## Installation & Setup

### Prerequisites

- **Java 11+** (OpenJDK or Oracle JDK)
- **Eclipse IDE 2023-06** or later with:
  - Xtext SDK 2.40.0
  - Xtend SDK 2.40.0
  - EMF (Eclipse Modeling Framework)
- **Maven 3.6+** (for command-line builds)

### Step 1: Clone the Repository

```bash
git clone https://github.com/i3lab-uex/xtext_syntax_MD4DSP.git
cd xtext_syntax_MD4DSP
```

### Step 2: Import into Eclipse

1. Open Eclipse
2. **File → Import → Existing Projects into Workspace**
3. Select root directory: `xtext_syntax_MD4DSP`
4. Import all projects:
   - `xtext.json.WorkflowDSL`
   - `xtext.json.WorkflowDSL.ide`
   - `xtext.json.WorkflowDSL.ui`
   - `xtext.json.WorkflowDSL.tests`
   - `xtext.json.WorkflowDSL.ui.tests`

### Step 3: Build the Project

- Project → Clean → Clean all projects
- Project → Build Automatically (should be enabled)

If there are still errors, the project will have to be built manually.

- Right-click on the projects with errors (e.g. xtext.json.WorkflowDSL.tests) → Build path → Configure Build Path ... → Apply and close.
- There is no need to select anything that is not selected by default.

### Step 4: Generate Xtext Artifacts

Right-click on `GenerateWorkflowDSL.mwe2` → **Run As → MWE2 Workflow**

This generates:
- Parser
- Lexer
- Serializer
- Validator
- Ecore model
- GenModel

### Step 5: Launch Runtime Eclipse

1. Right-click on `xtext.json.WorkflowDSL` project
2. **Run As → Eclipse Application**
3. A new Eclipse instance will launch with WorkflowDSL installed
4. In the new eclipse, create a new project (default).
5. Paste the .wf file containing the xtext model in the project.
6. Open the file in the project in eclipse and transform the project into a xtext project.
7. Then, you can modify the model and the json will be generated and updated automatically.

---

## WorkflowDSL Grammar Guide

### Basic Structure

Every `.wf` file follows this structure:

```
workflow <name> {
    source <identifier> = <data_reader>
    
    <step_1> = <transformation> |> <source>
    <step_2> = <transformation> |> <step_1>
    ...
}
```

### Grammar Rules Reference

#### 1. **Workflow Declaration**

```ebnf
Workflow:
    "workflow" name=STRING "{" 
        source=DataSource 
        body=WorkflowBody 
    "}";
```

**Example:**
```workflow
workflow "Student Data Pipeline" {
    source data = read_csv("/data/students.csv", ",")
    // ... steps
}
```

#### 2. **Data Source**

```ebnf
DataSource:
    "source" name=ID "=" reader=DataReader;

DataReader:
    CSVReader | FileReader;

CSVReader:
    "read_csv" "(" filePath=FilePath ("," delimiter=Delimiter)? ")";

FileReader:
    "read_file" "(" filePath=FilePath ")";
```

**Examples:**
```workflow
source data = read_csv("/data/students.csv", ",")
source raw = read_file("/data/input.txt")
```

#### 3. **Transformation Steps**

```ebnf
Step:
    name=ID "=" transformation=Transformation 
    ("|>" target=ID)? 
    contracts=ContractBlock?;
```

**Examples:**
```workflow
// Basic step
clean = filter_rows { missing(Age, exclude) } |> data

// Step with contracts
imputed = impute(Age) { 
    transform_special_to_mean(missing) 
} |> clean
    contracts {
        precondition "Age_has_missing" {
            has_special_values(input.Age, missing, max 60%)
        }
    }
```

#### 4. **Pipeline Operator (`|>`)**

The pipeline operator connects transformations sequentially:

```workflow
step1 = transformation1 |> data
step2 = transformation2 |> step1
step3 = transformation3 |> step2
```

Equivalent to: `data → transformation1 → transformation2 → transformation3`

---

## Creating .wf Files

### Workflow Template

Here's a complete template to start with:

```workflow
workflow "My Data Pipeline" {
    // 1. DEFINE DATA SOURCE
    source data = read_csv("/path/to/data.csv", ",")
    
    // 2. DATA CLEANING
    clean_missing = impute(column1, column2) {
        transform_special_to_mean(missing)
    } |> data
    
    // 3. FILTERING
    filtered = filter_rows {
        range(Age, [18, 100], include)
    } |> clean_missing
    
    // 4. TYPE CONVERSION
    numeric = to_numeric(Age, Score) |> filtered
    
    // 5. OUTLIER TREATMENT
    no_outliers = outliers(Score) {
        replace_by_closest(outlier)
    } |> numeric
    
    // 6. MAPPING
    categorized = map(Gender) {
        "M" -> "Male",
        "F" -> "Female"
    } as Gender |> no_outliers
    
    // 7. BINNING
    binned = bin(Age) {
        "Young": [0, 25),
        "Adult": [25, 60),
        "Senior": [60, 120]
    } as Age_Group |> categorized
}
```

### Step-by-Step Guide

#### Step 1: Create a New .wf File

1. In Runtime Eclipse, create a new file: **File → New → File**
2. Name it with `.wf` extension (e.g., `my_workflow.wf`)
3. The WorkflowDSL editor will open automatically

#### Step 2: Define the Workflow Header

```workflow
workflow "Your Workflow Name" {
```

#### Step 3: Add Data Source

```workflow
    source data = read_csv("/path/to/file.csv", ",")
```

#### Step 4: Add Transformation Steps

Each step follows the pattern:
```
<step_name> = <transformation_type>(<parameters>) { <options> } |> <previous_step>
```

#### Step 5: Add Contracts (Optional but Recommended)

```workflow
    contracts {
        precondition "name" { /* contract body */ }
        postcondition "name" { /* contract body */ }
        invariant "name" { /* contract body */ }
    }
```

#### Step 6: Close the Workflow

```workflow
}
```

---

## Contract System

Contracts ensure data quality and transformations correctness using **Design by Contract** principles.

### Contract Types

#### 1. **Preconditions**
Conditions that must be **true BEFORE** the transformation executes.

```workflow
precondition "Age_castable" {
    castable_to Integer(input.Age, belongs_to)
}
```

#### 2. **Postconditions**
Conditions that must be **true AFTER** the transformation completes.

```workflow
postcondition "Age_is_integer" {
    is_type Integer(output.Age, belongs_to)
}
```

#### 3. **Invariants**
Conditions that must be **preserved** during the transformation.

```workflow
invariant "Age_preservation" {
    condition {
        if { expression: input.Age not_belongs_to special_values }
        then { expression: output.Age not_belongs_to special_values }
    }
}
```

### Contract Syntax

#### Value Range Contracts

```workflow
value_range(field, value, belongOp?)
```

**Examples:**
```workflow
// Check if castable to type
value_range(input.Age, castable_to Integer)

// Check if in range
value_range(input.Score, in_range [0, 100])

// Check if matches value
value_range(output.Status, matches "Active")
```

#### Special Value Contracts

```workflow
has_special_values(field, specialType?, quantifier?, belongOp?)
no_special_values(field, specialType?, belongOp?)
```

**Examples:**
```workflow
// Has missing values (max 60%)
has_special_values(input.Age, missing, max 60%)

// No missing values
no_special_values(output.Age, missing)

// No outliers
no_special_values(output.Score, outlier)
```

#### Cast Type Contracts

```workflow
castable_to Type(field, belongOp?)
is_type Type(field, belongOp?)
```

**Examples:**
```workflow
// Precondition: can be cast
castable_to Integer(input.Age, belongs_to)

// Postcondition: is the type
is_type Integer(output.Age, belongs_to)
```

#### Condition Contracts (Invariants)

```workflow
condition {
    if { expression: <boolean_expression> }
    then { expression: <boolean_expression> }
}
```

**Examples:**
```workflow
invariant "preserve_non_missing" {
    condition {
        if { expression: input.Age not_belongs_to special_values }
        then { expression: output.Age not_belongs_to special_values }
    }
}

invariant "type_preservation" {
    condition {
        if { expression: input.Age belongs_to type Integer }
        then { expression: output.Age belongs_to type Integer }
    }
}
```

#### Field Range Contracts (Column Filter)

```workflow
field_range(column_list; belongOp)
```

**Example:**
```workflow
precondition "columns_exist" {
    field_range(col1, col2, col3; belongs_to)
}

postcondition "columns_removed" {
    field_range(col1, col2, col3; not_belongs_to)
}
```

### Contract Naming Conventions

Use descriptive names that follow this pattern:
```
<operation>(<columns>)_<TYPE>_<contractKind>_<variant>
```

**Examples:**
```
"imputeMissingByMean(Age)_PRE_valueRange"
"stringToNumber(Age)_POST_castType"
"INV_StringToNumber_condition_Age"
"columnFilter(col1, col2)_PRE_fieldRange"
```

---

## Transformations Reference

### 1. **Imputation** - Fill Missing Values

```workflow
impute(column1, column2, ...) {
    <imputation_method>
}
```

#### Methods:

**Statistical Imputation:**
```workflow
impute(Age, Income) {
    transform_special_to_mean(missing)
}

impute(Score) {
    transform_special_to_median(missing)
}

impute(Category) {
    transform_special_to_most_frequent(missing)
}

impute(Value) {
    transform_special_to_interpolation(missing, linear)
}
```

**Fixed Value:**
```workflow
impute(Status, Category) {
    transform_special_to_fixed(missing, "Unknown")
}
```

**Sequential:**
```workflow
impute(Temperature) {
    transform_special_to_previous_value(missing)
}

impute(Pressure) {
    transform_special_to_next_value(missing)
}
```

### 2. **Row Filtering**

```workflow
filter_rows {
    <filter_condition>
}
```

#### Conditions:

**Range Filter:**
```workflow
filter_rows {
    range(Age, [18, 65], include)
}

filter_rows {
    range(Score, [0, 100), exclude)
}
```

**Missing Filter:**
```workflow
filter_rows {
    missing(Age, Grade, exclude)
}
```

**String Filter:**
```workflow
filter_rows {
    matches(Name, "John*", include)
}
```

### 3. **Column Filtering**

```workflow
// Keep specific columns
select_columns { Age, Name, Score }

// Remove specific columns
drop_columns { TempId, Debug }

// Alternative syntax
keep { Age, Name }
remove { TempId, Debug }
```

### 4. **Mapping** - Value Transformation

```workflow
map(column) {
    "old_value1" -> "new_value1",
    "old_value2" -> "new_value2"
} <mode>
```

#### Modes:
- `replace` - Replace original column
- `as <new_name>` - Create new column

**Examples:**
```workflow
map(Gender) {
    "M" -> "Male",
    "F" -> "Female"
} as GenderFull

map(Status) {
    "A" -> "Active",
    "I" -> "Inactive"
} replace
```

### 5. **Type Conversion**

```workflow
to_numeric(column1, column2, ...) separator?
to_string(column1, column2)
to_categorical(column1)
to_boolean(column1)
to_date(column1, format?)
```

**Examples:**
```workflow
to_numeric(Age, Score) separator = "."
to_date(BirthDate, format = "YYYY-MM-DD")
```

### 6. **Outlier Treatment**

```workflow
outliers(column1, column2, ...) {
    <strategy>
}
```

#### Strategies:
```workflow
outliers(Age, Income) {
    replace_by_closest(outlier)
}

outliers(Score) {
    replace_with(outlier, 0)
}

outliers(Value) {
    remove(outlier)
}
```

### 7. **Binning** - Discretization

```workflow
bin(column) {
    "bin_name1": interval1,
    "bin_name2": interval2,
    ...
} <mode>
```

#### Interval Notation:
- `[a, b]` - Closed: includes both a and b
- `[a, b)` - Half-open: includes a, excludes b
- `(a, b]` - Half-open: excludes a, includes b
- `(a, b)` - Open: excludes both a and b
- `-Infinity` / `Infinity` - Unbounded

**Examples:**
```workflow
bin(Age) {
    "Young": [-Infinity, 25),
    "Adult": [25, 60),
    "Senior": [60, Infinity)
} as AgeGroup

bin(Score) {
    "Low": [0, 50),
    "Medium": [50, 75),
    "High": [75, 100]
} replace
```

### 8. **Mathematical Operations**

```workflow
math(expression) as new_column
```

**Example:**
```workflow
math(BMI = Weight / (Height * Height)) as BMI
```

### 9. **Join Operations**

```workflow
join(left_dataset, right_dataset) {
    <join_type> on conditions options?
}
```

**Example:**
```workflow
join(students, grades) {
    inner on StudentID = StudentID
}
```

---

## Code Generation

### How It Works

The `WorkflowDSLGenerator.xtend` file transforms `.wf` files into JSON:

1. **Parse .wf file** → AST (Abstract Syntax Tree)
2. **Traverse AST** using Xtend template expressions
3. **Generate JSON** with three sections:
   - `nodes` - Transformation nodes
   - `connections` - Data flow between nodes
   - `contracts` - Pre/post conditions and invariants

### Output Structure

```json
{
    "nodes": [
        {
            "id": 1,
            "node_name": "File Reader",
            "node_type": "org.knime.base.node...",
            "parameters": { ... }
        },
        ...
    ],
    "connections": [
        {
            "sourceID": 1,
            "destID": 2
        },
        ...
    ],
    "contracts": {
        "1": {
            "columns": {
                "Age": {
                    "preconditions": [...],
                    "postconditions": [...],
                    "invariants": [...]
                }
            }
        },
        ...
    }
}
```

### Generating JSON

1. Save your `.wf` file
2. JSON is automatically generated in `src-gen/` folder
3. File name: `<WorkflowName>.json`

```

---

## Examples

### Example 1: Simple Data Cleaning

```workflow
workflow "Simple Cleaning" {
    source data = read_csv("/data/raw.csv", ",")
    
    cleaned = impute(Age, Income) {
        transform_special_to_mean(missing)
    } |> data
        contracts {
            precondition "has_missing" {
                has_special_values(input.Age, missing, max 60%)
            }
            postcondition "no_missing" {
                no_special_values(output.Age, missing)
            }
        }
}
```

### Example 2: Complete Student Pipeline

```workflow
workflow "Student Data Pipeline" {
    source data = read_csv("/data/students.csv", ",")
    
    // Clean missing categorical
    clean_cat = impute(Gender, Major) {
        transform_special_to_most_frequent(missing)
    } |> data
    
    // Clean missing numeric
    clean_num = impute(Age, GPA) {
        transform_special_to_mean(missing)
    } |> clean_cat
    
    // Filter valid ages
    filtered = filter_rows {
        range(Age, [18, 100], include)
    } |> clean_num
    
    // Convert types
    typed = to_numeric(Age, GPA) |> filtered
    
    // Remove outliers
    no_outliers = outliers(GPA) {
        replace_by_closest(outlier)
    } |> typed
    
    // Categorize GPA
    categorized = bin(GPA) {
        "Low": [0.0, 2.5),
        "Medium": [2.5, 3.5),
        "High": [3.5, 4.0]
    } as GPA_Category |> no_outliers
}
```

### Example 3: With Comprehensive Contracts

```workflow
workflow "Contracted Pipeline" {
    source data = read_csv("/data/data.csv", ",")
    
    converted = to_numeric(Age, Score) |> data
        contracts {
            precondition "Age_castable" {
                castable_to Integer(input.Age, belongs_to)
            }
            precondition "Score_castable" {
                castable_to Integer(input.Score, belongs_to)
            }
            postcondition "Age_is_integer" {
                is_type Integer(output.Age, belongs_to)
            }
            postcondition "Score_is_integer" {
                is_type Integer(output.Score, belongs_to)
            }
            invariant "preserve_non_null" {
                condition {
                    if { expression: input.Age not_belongs_to special_values }
                    then { expression: output.Age not_belongs_to special_values }
                }
            }
        }
}
```

---

## Troubleshooting

### Common Issues

#### 1. **Syntax Errors in .wf File**

**Problem:** Red underlines and error markers

**Solutions:**
- Check for missing semicolons, braces, or quotes
- Verify keyword spelling (case-sensitive)
- Use content assist (Ctrl+Space) for suggestions
- Check the Xtext validation messages

#### 2. **Generated JSON Not Appearing**

**Problem:** No file in `src-gen/` folder

**Solutions:**
- Ensure the `.wf` file has no syntax errors
- Check Eclipse Error Log (Window → Show View → Error Log)
- Rebuild the project (Project → Clean)
- Regenerate Xtext artifacts

#### 3. **Eclipse Won't Start Runtime**

**Problem:** "Could not find or load main class"

**Solutions:**
- Clean all projects (Project → Clean → Clean all projects)
- Run → Run Configurations → Eclipse Application → Clean
- Delete `.metadata` folder in runtime workspace
- Restart Eclipse

#### 4. **Content Assist Not Working**

**Problem:** Ctrl+Space doesn't show suggestions

**Solutions:**
- Ensure Xtext artifacts are generated
- Check that `xtext.json.WorkflowDSL.ide` is loaded
- Restart Runtime Eclipse
- Check for errors in grammar file

#### 5. **Invalid Generated JSON**

**Problem:** JSON doesn't parse correctly

**Solutions:**
- Check `WorkflowDSLGenerator.xtend` for syntax errors
- Verify contract names don't contain special characters
- Check for null values in transformations
- Validate JSON with online validator

1. Check Eclipse Console for detailed errors

### Getting Help

- **Xtext Documentation**: https://www.eclipse.org/Xtext/documentation/
- **EMF Guide**: https://www.eclipse.org/modeling/emf/
- **Xtend Language**: https://www.eclipse.org/xtend/

---

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

---

## Authors

- **Carlos Breuer Carrasco** - Development and documentation
- **Carlos Cambero Rojas** - Development and documentation

---

**Built with Eclipse Xtext**
