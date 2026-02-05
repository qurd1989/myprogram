# Glossary of Terms

A quick reference for terms used in this project.

## Project Structure Terms

**Bootstrap**  
Setting up the initial structure and configuration of a project.

**Package**  
A directory containing Python modules and an `__init__.py` file.

**Module**  
A single Python file (like `main.py`, `utils.py`).

**Entry Point**  
The function that gets called when you run a command (defined in `setup.py`).

---

## CLI Terms

**CLI (Command-Line Interface)**  
A text-based interface for interacting with programs via terminal/command prompt.

**Command**  
An action you can perform (like `myprogram greet`).

**Subcommand**  
A command within a command group (in `myprogram greet`, "greet" is the subcommand).

**Option/Flag**  
Additional parameters you can pass to commands (like `--name Alice`).

**Argument**  
A value passed to a command (in `myprogram greet Alice`, "Alice" is an argument).

---

## Python Concepts

**Decorator (`@`)**  
A Python feature that modifies or enhances functions. Example: `@click.command()`.

**Docstring**  
Documentation inside triple quotes (`"""..."""`) that describes what code does.

**`__name__`**  
Special Python variable that tells if a file is being run directly or imported.

**`__init__.py`**  
Special file that makes a directory a Python package.

**`__version__`**  
Convention for storing a package's version number.

---

## Package Management Terms

**pip**  
Python's package installer (Python Install Package).

**requirements.txt**  
File listing all packages your project needs.

**setup.py**  
Configuration file for installing your package.

**Virtual Environment (venv)**  
Isolated Python environment for your project.

**Dependency**  
Another package your project needs to work (like Click).

**Editable Install (`-e`)**  
Install mode where changes to source code take effect immediately.

---

## Testing Terms

**pytest**  
Popular Python testing framework.

**Test Coverage**  
Percentage of your code that has tests.

**Unit Test**  
Test that checks a single function or small piece of code.

**Test Fixture**  
Setup code that prepares conditions for tests.

**Assertion**  
Statement that checks if something is true in a test.

---

## Git Terms

**.gitignore**  
File that tells Git which files to not track.

**Repository (Repo)**  
Project folder tracked by Git.

**Commit**  
Saving changes to Git history.

**Branch**  
Separate line of development.

---

## Click Framework Terms

**`@click.command()`**  
Decorator that makes a function a CLI command.

**`@click.group()`**  
Decorator that creates a command group that can contain subcommands.

**`@click.option()`**  
Decorator that adds a command-line option/flag.

**`@click.argument()`**  
Decorator that adds a positional argument.

**`click.echo()`**  
Click's version of `print()` that works better for CLI apps.

---

## Configuration Terms

**Environment Variable**  
System-wide variable that programs can read (like `DEBUG=true`).

**Config File**  
File storing program settings.

**Configuration Management**  
System for handling different settings (development vs production).

---

## Project Organization Terms

**Source Directory (`src/`)**  
Where application code lives.

**Test Directory (`tests/`)**  
Where test code lives.

**Distribution**  
Packaged version of your code ready for sharing.

**Namespace**  
Organizational structure preventing naming conflicts.

---

## Development Terms

**Linting**  
Checking code for style and potential errors.

**Formatter (black)**  
Tool that automatically formats code.

**flake8**  
Linting tool for Python.

**Code Coverage**  
Measurement of how much code is tested.

---

## Common Abbreviations

**CLI** - Command-Line Interface  
**API** - Application Programming Interface  
**SDK** - Software Development Kit  
**REPL** - Read-Eval-Print Loop  
**TTY** - TeleTYpewriter (terminal)  
**EOF** - End Of File  
**STDIN** - Standard Input  
**STDOUT** - Standard Output  
**STDERR** - Standard Error  

---

## Quick Reference: Commands

```bash
# Install package in editable mode
pip install -e .

# Install dependencies
pip install -r requirements.txt

# Run tests
pytest

# Run with coverage
pytest --cov=myprogram

# Lint code
flake8 src/ tests/

# Format code
black src/ tests/

# See help
myprogram --help

# Run a command
myprogram greet --name Alice
```

---

## File Extensions

**.py** - Python source file  
**.pyc** - Compiled Python bytecode  
**.txt** - Text file (often requirements)  
**.md** - Markdown documentation  
**.yaml/.yml** - YAML configuration file  
**.json** - JSON data file  

---

## Related Concepts

**Package Manager**  
Tool for installing software (pip for Python, npm for JavaScript).

**Build Tool**  
Tool that compiles/packages code.

**Continuous Integration (CI)**  
Automatically testing code when changes are made.

**Version Control**  
System for tracking changes (Git).

---

## Where These Terms Are Used

| Term | File/Location |
|------|---------------|
| Decorator | `src/myprogram/main.py` |
| Entry Point | `setup.py` |
| Dependency | `requirements.txt` |
| Package | `src/myprogram/` |
| Test | `tests/` |
| Docstring | All `.py` files |
| CLI Command | `src/myprogram/main.py` |
| Version | `src/myprogram/__init__.py` |

---

## Learning Path

1. **Start here**: Basic Python (`def`, `import`, `if`)
2. **Then learn**: Functions and modules
3. **Then learn**: Packages and imports
4. **Then learn**: CLI with Click
5. **Finally learn**: Testing with pytest

Don't worry if you don't understand everything at once! These concepts build on each other.
