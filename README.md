# WorkflowDSL - Domain-Specific Language for Data Processing Workflows

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Xtext](https://img.shields.io/badge/Xtext-2.x-orange.svg)](https://www.eclipse.org/Xtext/)

## 📋 Descripción del Proyecto

**WorkflowDSL** es un lenguaje específico de dominio (DSL) desarrollado con Xtext para la definición y generación de pipelines de procesamiento de datos. El proyecto permite a los usuarios definir workflows de transformación de datos de manera declarativa y generar automáticamente código JSON ejecutable.

Este DSL está diseñado específicamente para facilitar el diseño, documentación y validación de procesos de datos científicos (Data Science Pipelines), incluyendo:

- 📊 Lectura de datos desde múltiples fuentes
- 🔄 Transformaciones de datos complejas
- ✅ Contratos y validaciones (precondiciones, postcondiciones, invariantes)
- 📈 Operaciones de limpieza, filtrado e imputación
- 🔗 Uniones (joins) de datasets
- 📐 Binning y discretización de datos
- 🎯 Detección y tratamiento de outliers

## 🎯 Características Principales

### 1. **Sintaxis Declarativa y Legible**
```workflow
workflow "Student Data Pipeline" {
    source data = read_csv("/data/students.csv", ,)
    
    clean = filter_rows {
        missing(Age, Grade, exclude)
    } |> data
    
    numeric = to_numeric(Age, Grade) |> clean
}
```

### 2. **Sistema de Contratos (Design by Contract)**
Permite definir precondiciones, postcondiciones e invariantes para validar transformaciones:

```workflow
contracts {
    precondition "Age_castable" {
        value_range(input.Age, castable_to Integer)
    }
    
    postcondition "Age_is_integer" {
        is_type Integer(output.Age)
    }
    
    invariant "Age_no_special" {
        condition {
            if input.Age not_belongs_to special_values
            then output.Age not_belongs_to special_values
        }
    }
}
```

### 3. **Pipeline Operators**
Uso del operador `|>` para encadenar transformaciones de manera fluida:

```workflow
result = transform_1 |> transform_2 |> transform_3
```

### 4. **Generación Automática de JSON**
El DSL genera automáticamente código JSON estructurado que puede ser interpretado por motores de ejecución de pipelines.

## 🏗️ Estructura del Proyecto

```
xtext_syntax_MD4DSP-1/
├── json.WorkflowDSL/                    # Proyecto de ejemplo
│   ├── workflow.wf                       # Archivo de workflow de ejemplo
│   └── src-gen/                          # JSON generado automáticamente
│       └── Student Data Pipeline.json
│
├── xtext.json.WorkflowDSL/              # Proyecto principal del DSL
│   ├── src/
│   │   └── xtext/json/
│   │       ├── WorkflowDSL.xtext        # Gramática del DSL
│   │       ├── generator/               # Generadores de código
│   │       ├── validation/              # Validadores semánticos
│   │       ├── scoping/                 # Reglas de alcance
│   │       └── export/                  # Exportadores JSON
│   ├── model/generated/                 # Metamodelo EMF generado
│   └── META-INF/                        # Configuración del plugin
│
├── xtext.json.WorkflowDSL.ide/          # Soporte IDE (LSP)
│   └── src-gen/                          # Código generado para IDE
│
├── xtext.json.WorkflowDSL.ui/           # Interfaz de usuario Eclipse
│   ├── src/
│   │   └── xtext/json/ui/
│   │       ├── contentassist/           # Autocompletado
│   │       ├── labeling/                # Etiquetado de elementos
│   │       ├── outline/                 # Vista de outline
│   │       └── quickfix/                # Correcciones rápidas
│   └── plugin.xml                       # Configuración del plugin UI
│
├── xtext.json.WorkflowDSL.tests/        # Tests del lenguaje
│   └── src/
│       └── xtext/json/tests/
│
└── xtext.json.WorkflowDSL.ui.tests/     # Tests de la UI
```

## 🔧 Tecnologías Utilizadas

- **[Eclipse Xtext](https://www.eclipse.org/Xtext/)** - Framework para desarrollo de DSLs
- **[Eclipse EMF](https://www.eclipse.org/modeling/emf/)** - Modeling Framework
- **[Xtend](https://www.eclipse.org/xtend/)** - Lenguaje para generación de código
- **Java** - Lenguaje de implementación
- **Gradle/Maven** - Gestión de dependencias

## 📚 Gramática del DSL

### Elementos Principales

#### 1. **Workflow**
```ebnf
workflow "nombre" {
    source <fuente_datos>
    <pasos_transformacion>
}
```

#### 2. **Fuentes de Datos**
- **CSV Reader**: `read_csv(path, delimiter)`
- **File Reader**: `read_file(path)`

#### 3. **Transformaciones Soportadas**

##### Filtrado
- `filter_rows { ... }` - Filtrado por filas
- `filter_columns { ... }` - Filtrado por columnas
- `filter_strings { ... }` - Filtrado de strings
- `filter_ranges { ... }` - Filtrado por rangos

##### Conversión de Tipos
- `to_numeric(columns...)` - Conversión a numérico
- `to_string(columns...)` - Conversión a string
- `to_date(columns...)` - Conversión a fecha

##### Imputación de Valores Faltantes
- `impute_fixed(column, value)` - Imputación con valor fijo
- `impute_statistical(column, method)` - Imputación estadística (mean, median, mode)
- `impute_sequential(column, method)` - Imputación secuencial (forward_fill, backward_fill)
- `impute_advanced(column, method)` - Imputación avanzada (interpolation, regression)

##### Tratamiento de Outliers
- `detect_outliers { ... }` - Detección de outliers
- `treat_outliers { ... }` - Tratamiento de outliers

##### Binning
- `bin_data { ... }` - Discretización de datos continuos

##### Joins
- `join { ... }` - Unión de datasets

##### Mapping
- `map_values { ... }` - Mapeo de valores
- `map_substring { ... }` - Mapeo basado en substring

##### Expresiones Matemáticas
- Operadores: `+`, `-`, `*`, `/`, `%`, `^`
- Funciones: `sqrt`, `abs`, `log`, `exp`, etc.

### 4. **Contratos**

Los contratos permiten especificar garantías sobre las transformaciones:

```workflow
contracts {
    precondition "nombre" {
        // Condición que debe cumplirse antes de la transformación
    }
    
    postcondition "nombre" {
        // Condición que debe cumplirse después de la transformación
    }
    
    invariant "nombre" {
        // Condición que debe mantenerse durante la transformación
    }
}
```

#### Tipos de Contratos:

1. **Value Range Contract**
   ```workflow
   value_range(input.column, castable_to Integer)
   value_range(output.column, in_range [0, 100])
   ```

2. **Condition Contract**
   ```workflow
   condition {
       if input.column belongs_to special_values
       then output.column not_belongs_to special_values
   }
   ```

3. **Type Contract**
   ```workflow
   is_type Integer(output.column)
   ```

## 🚀 Instalación y Configuración

### Requisitos Previos

- Java JDK 11 o superior
- Eclipse IDE con Xtext SDK instalado
- Maven o Gradle

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/i3lab-uex/xtext_syntax_MD4DSP.git
   cd xtext_syntax_MD4DSP
   ```

2. **Importar en Eclipse**
   - Abrir Eclipse IDE
   - File → Import → Existing Projects into Workspace
   - Seleccionar el directorio del repositorio
   - Importar todos los proyectos

3. **Generar el código Xtext**
   - Click derecho en `WorkflowDSL.xtext`
   - Run As → Generate Xtext Artifacts

4. **Ejecutar el runtime Eclipse**
   - Click derecho en el proyecto principal
   - Run As → Eclipse Application

## 💻 Uso del DSL

### 1. Crear un Nuevo Archivo Workflow

Crear un archivo con extensión `.wf`:

```workflow
workflow "Mi Pipeline" {
    source datos = read_csv("/ruta/datos.csv", ,)
    
    limpio = filter_rows {
        missing(columna1, columna2, exclude)
    } |> datos
    
    resultado = to_numeric(columna1) |> limpio
}
```

### 2. Validación Automática

El editor proporciona:
- ✅ Validación sintáctica en tiempo real
- 🔍 Validación semántica
- 💡 Sugerencias de autocompletado
- ⚡ Quick fixes para errores comunes

### 3. Generación de JSON

El JSON se genera automáticamente en la carpeta `src-gen/`:

```json
{
  "type": "workflow",
  "name": "Mi Pipeline",
  "source": {
    "type": "data_source",
    "name": "datos",
    "reader": {
      "type": "csv_reader",
      "file_path": {
        "path": "/ruta/datos.csv"
      }
    }
  },
  "body": {
    "steps": [...]
  }
}
```

## 📖 Ejemplos de Uso

### Ejemplo 1: Pipeline de Limpieza Básico

```workflow
workflow "Data Cleaning Pipeline" {
    source raw_data = read_csv("/data/raw.csv", ,)
    
    no_missing = filter_rows {
        missing(Age, Salary, exclude)
    } |> raw_data
    
    normalized = to_numeric(Age, Salary) |> no_missing
}
```

### Ejemplo 2: Pipeline con Contratos

```workflow
workflow "Validated Pipeline" {
    source data = read_csv("/data/input.csv", ,)
    
    validated = to_numeric(Score) |> data contracts {
        precondition "score_valid_range" {
            value_range(input.Score, in_range [0, 100])
        }
        
        postcondition "score_is_numeric" {
            is_type Integer(output.Score)
        }
    }
}
```

### Ejemplo 3: Pipeline con Imputación y Outliers

```workflow
workflow "Advanced Pipeline" {
    source data = read_csv("/data/sensor.csv", ,)
    
    imputed = impute_statistical(Temperature, mean) |> data
    
    clean = treat_outliers {
        columns(Temperature)
        method(iqr, threshold 1.5)
        strategy(clip)
    } |> imputed
}
```

### Ejemplo 4: Pipeline con Join

```workflow
workflow "Join Pipeline" {
    source students = read_csv("/data/students.csv", ,)
    source grades = read_csv("/data/grades.csv", ,)
    
    merged = join {
        left students
        right grades
        on student_id = student_id
        type inner
    }
}
```

## 🧪 Testing

### Ejecutar Tests

```bash
# Ejecutar todos los tests
./gradlew test

# O en Eclipse
Click derecho en xtext.json.WorkflowDSL.tests → Run As → JUnit Test
```

### Ejemplo de Test

```java
@Test
public void testWorkflowParsing() throws Exception {
    Workflow workflow = parseHelper.parse("""
        workflow "Test" {
            source data = read_csv("/test.csv", ,)
        }
    """);
    assertNotNull(workflow);
    assertEquals("Test", workflow.getName());
}
```

## 🛠️ Desarrollo y Extensión

### Añadir Nuevas Transformaciones

1. **Actualizar la gramática** en `WorkflowDSL.xtext`:
   ```xtext
   MiNuevaTransformacion:
       'mi_transformacion' '(' parametros ')';
   ```

2. **Regenerar artefactos Xtext**

3. **Implementar el generador** en `WorkflowDSLGenerator.xtend`:
   ```xtend
   def dispatch CharSequence compile(MiNuevaTransformacion t) '''
       {
           "type": "mi_transformacion",
           ...
       }
   '''
   ```

4. **Añadir validación** si es necesario en `WorkflowDSLValidator.java`

### Añadir Nuevos Contratos

1. Extender la gramática con el nuevo tipo de contrato
2. Implementar la lógica de validación
3. Actualizar el generador JSON

## 📊 Formato de Salida JSON

El DSL genera JSON estructurado siguiendo un esquema consistente:

```json
{
  "type": "workflow",
  "name": "...",
  "source": {...},
  "body": {
    "steps": [
      {
        "type": "step",
        "name": "...",
        "transformation": {...},
        "target": "...",
        "contracts": [...]
      }
    ]
  }
}
```

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Ramas del Proyecto

- **`main`**: Rama principal estable
- **`develop`**: Rama de desarrollo activa
- **`dev_ccr`**: Rama de desarrollo actual (Carlos)
- **`dev_cbc`**: Rama de desarrollo (CBC)

## 📄 Licencia

Este proyecto está licenciado bajo Apache License 2.0. Ver el archivo `LICENSE` para más detalles.

## 👥 Autores

- **i3lab-uex** - Universidad de Extremadura
- Desarrolladores del proyecto MD4DSP (Model-Driven for Data Science Pipelines)

## 🔗 Enlaces Útiles

- [Documentación de Xtext](https://www.eclipse.org/Xtext/documentation/)
- [Eclipse Modeling Framework](https://www.eclipse.org/modeling/emf/)
- [Xtend Language](https://www.eclipse.org/xtend/)

## 📧 Contacto

Para preguntas, sugerencias o problemas, por favor abre un issue en el repositorio de GitHub.

---

**Nota**: Este proyecto está en desarrollo activo. La sintaxis y características pueden cambiar.

## 🗺️ Roadmap

- [ ] Soporte para más formatos de entrada (JSON, Parquet, Excel)
- [ ] Generación de código Python/R además de JSON
- [ ] Validación en tiempo de ejecución
- [ ] Dashboard de visualización de pipelines
- [ ] Integración con frameworks de ML (scikit-learn, pandas)
- [ ] Soporte para pipelines distribuidos (Spark, Dask)

## 📈 Estado del Proyecto

- ✅ Gramática base implementada
- ✅ Generación JSON funcional
- ✅ Sistema de contratos implementado
- ✅ Editor Eclipse con syntax highlighting
- ✅ Autocompletado básico
- 🚧 Validación semántica avanzada (en progreso)
- 🚧 Generación de código ejecutable (en progreso)
- 📋 Dashboard de visualización (planificado)

---

**Version**: 1.0.0  
**Last Updated**: Octubre 2025
