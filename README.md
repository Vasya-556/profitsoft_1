# First task

This app parse JSON files with arrays of movies and directors and generate XML based on it.

## Installing

1. Clone this repository
```bash
git clone
```
2. Navigate inside the folder
```bash
cd 
```
3. Build project
```bash
mvn clean compile
```

## Usage

```bash
mvn exec:java -Dexec.args="<folder> <attribute> <threads>"
```
- `<folder>` – path to the folder containing JSON files (can be relative or absolute)  
  - Relative paths: `./movies` (works on any OS)
  - Absolute paths:
    - Linux/macOS: `/home/user/movies`
    - Windows: `C:/Users/User/movies` or `C:\\Users\\User\\movies`
- `<attribute>` – the attribute to generate statistics for: `director`, `year`, or `genres`  
- `<threads>` – number of threads to use for parsing files concurrently  


### Entity: Movies

- **`title`** (String)
- **`year`** (Integer)
- **`director`** (String)
- **`genres`** (String)

### Example

```bash
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="./movies year 4"
```

#### Input

```json
[
  {
    "title": "Inception",
    "director": { "name": "Christopher Nolan" },
    "year": 2010,
    "genres": "Sci-Fi, Thriller"
  },
  {
    "title": "Interstellar",
    "director": { "name": "Christopher Nolan" },
    "year": 2014,
    "genres": "Sci-Fi, Drama"
  }
]
```

#### Output

```xml
<statistics>
  <item>
    <value>Sci-Fi</value>
    <count>2</count>
  </item>
  <item>
    <value>Drama</value>
    <count>1</count>
  </item>
  <item>
    <value>Thriller</value>
    <count>1</count>
  </item>
</statistics>
```

## Tests

```bash
mvn test
```

## Performance

```bash
mvn exec:java -Dexec.mainClass="com.example.PerformanceTimer" -Dexec.args="./movies genres"
```

- Execution time 1 Threads: 153.3370 milliseconds
- Execution time 2 Threads: 3.1281 milliseconds
- Execution time 4 Threads: 3.5348 milliseconds
- Execution time 8 Threads: 2.9938 milliseconds