# Interactive Tutorial: Understanding the Code

This tutorial walks you through the code step-by-step. Follow along by opening the files mentioned!

## Part 1: Starting Simple

### Step 1: Look at `src/myprogram/__init__.py`

Open the file and you'll see:
```python
"""
MyProgram - A simple Python application starter template.
"""

__version__ = "0.1.0"
```

**What's happening here?**
- The triple-quoted string is documentation
- `__version__` stores the version number
- Other files can import this: `from myprogram import __version__`

**Try it yourself:**
```bash
python -c "from myprogram import __version__; print(__version__)"
```

---

## Part 2: Understanding the Main Application

### Step 2: Open `src/myprogram/main.py`

Let's break it down piece by piece:

#### Import Section:
```python
import click
from myprogram import __version__
from myprogram.utils import format_greeting
```

**What's happening:**
1. Import the Click library for CLI features
2. Import our version number
3. Import a helper function from utils

**Try modifying:**
Add `print("Loading...")` after the imports and run `myprogram` to see it execute!

---

#### The CLI Group:
```python
@click.group()
@click.version_option(version=__version__)
def cli():
    """MyProgram - A simple Python application starter template."""
    pass
```

**What's happening:**
- `@click.group()` - This function becomes a command group
- `@click.version_option()` - Adds automatic `--version` flag
- `pass` - The function body is empty because Click handles everything

**Try it:**
```bash
myprogram --version
myprogram --help
```

---

#### The Greet Command:
```python
@cli.command()
@click.option('--name', default='World', help='Name to greet')
def greet(name):
    """Greet someone with a friendly message."""
    message = format_greeting(name)
    click.echo(message)
    return message
```

**What each part does:**

1. `@cli.command()` - Adds this as a subcommand of `cli`
2. `@click.option('--name', ...)` - Creates the `--name` flag
   - `default='World'` - Used if user doesn't provide a name
   - `help='...'` - Shows up in `--help` text
3. `def greet(name):` - Function that receives the name
4. `format_greeting(name)` - Calls helper function from utils.py
5. `click.echo(message)` - Prints to terminal
6. `return message` - Returns value (useful for testing)

**Try it:**
```bash
myprogram greet
myprogram greet --name "Your Name"
myprogram greet --help
```

**Exercise: Add your own option!**
Try adding a `--greeting` option that changes "Hello" to something else:
```python
@cli.command()
@click.option('--name', default='World', help='Name to greet')
@click.option('--greeting', default='Hello', help='Greeting to use')
def greet(name, greeting):
    """Greet someone with a friendly message."""
    message = f"{greeting}, {name}! Welcome to MyProgram."
    click.echo(message)
    return message
```

---

#### The Info Command:
```python
@cli.command()
def info():
    """Display information about the application."""
    info_text = f"""
MyProgram v{__version__}
====================
A simple Python application starter template.

This is a basic CLI application that demonstrates:
- Command-line interface with Click
- Modular project structure
- Basic testing setup
- Configuration management
"""
    click.echo(info_text)
```

**What's happening:**
- No options needed, so no `@click.option()`
- Uses f-string to include `{__version__}`
- Triple-quoted string for multi-line text

**Try it:**
```bash
myprogram info
```

**Exercise: Modify the info text**
Change the version number in `src/myprogram/__init__.py` and run `myprogram info` again. See how it updates?

---

#### The Entry Point:
```python
def main():
    """Main entry point for the application."""
    cli()

if __name__ == '__main__':
    main()
```

**What's happening:**
1. `main()` function calls `cli()` to start the Click app
2. `if __name__ == '__main__'` - Only runs if file is executed directly
3. This is what runs when you type `myprogram` in your terminal

---

## Part 3: Understanding Utils

### Step 3: Open `src/myprogram/utils.py`

```python
def format_greeting(name):
    """
    Format a greeting message for a given name.
    
    Args:
        name (str): The name to greet
        
    Returns:
        str: A formatted greeting message
    """
    return f"Hello, {name}! Welcome to MyProgram."
```

**What's happening:**
- Simple function that takes a name
- Returns a formatted string
- Documentation explains what it does

**Why separate this?**
- **Reusability** - Can be used by multiple commands
- **Testing** - Easy to test in isolation
- **Organization** - Keeps main.py cleaner

**Try it:**
```python
from myprogram.utils import format_greeting
print(format_greeting("Alice"))
```

**Exercise: Add more utilities**
Add a function that counts the letters in a name:
```python
def count_letters(name):
    """Count letters in a name."""
    return len(name)
```

Then use it in your greet command!

---

## Part 4: Understanding Config

### Step 4: Open `src/myprogram/config.py`

```python
class Config:
    """Application configuration class."""

    def __init__(self):
        self.app_name = "MyProgram"
        self.version = "0.1.0"
        self.debug = os.getenv("DEBUG", "false").lower() == "true"
        self.log_level = os.getenv("LOG_LEVEL", "INFO")
```

**What's happening:**
- `Config` is a class that holds settings
- `os.getenv("DEBUG", "false")` reads environment variable, defaults to "false"
- Settings can be changed without modifying code

**Try it:**
```bash
# Without DEBUG
python -c "from myprogram.config import config; print(config.debug)"

# With DEBUG
DEBUG=true python -c "from myprogram.config import config; print(config.debug)"
```

**Exercise: Add your own config**
Add a `language` setting with default "en":
```python
self.language = os.getenv("LANGUAGE", "en")
```

---

## Part 5: Understanding Tests

### Step 5: Open `tests/test_main.py`

```python
def test_greet_default():
    """Test the greet command with default name."""
    runner = CliRunner()
    result = runner.invoke(cli, ['greet'])
    assert result.exit_code == 0
    assert "Hello, World!" in result.output
```

**What's happening:**
1. `CliRunner()` - Click's test helper
2. `runner.invoke(cli, ['greet'])` - Simulates running `myprogram greet`
3. `assert result.exit_code == 0` - Check it didn't crash
4. `assert "Hello, World!" in result.output` - Check the output

**Try it:**
```bash
pytest tests/test_main.py::test_greet_default -v
```

**Exercise: Write your own test**
Test the greet command with your name:
```python
def test_greet_my_name():
    """Test greeting with my name."""
    runner = CliRunner()
    result = runner.invoke(cli, ['greet', '--name', 'YourName'])
    assert result.exit_code == 0
    assert "Hello, YourName!" in result.output
```

---

## Part 6: Understanding setup.py

### Step 6: Open `setup.py`

The most important part:
```python
entry_points={
    "console_scripts": [
        "myprogram=myprogram.main:main",
    ],
},
```

**What's happening:**
- Creates a command called `myprogram`
- Points to `main()` function in `myprogram.main` module
- This is why you can type `myprogram` instead of `python src/myprogram/main.py`

**Exercise: Change the command name**
Change `"myprogram=..."` to `"myapp=..."`, reinstall, and try:
```bash
pip install -e .
myapp --help
```

Don't forget to change it back!

---

## Part 7: Hands-On Exercises

### Exercise 1: Add a Goodbye Command

Add this to `src/myprogram/main.py`:
```python
@cli.command()
@click.option('--name', default='friend', help='Name to say goodbye to')
def goodbye(name):
    """Say goodbye to someone."""
    click.echo(f"Goodbye, {name}! Thanks for using MyProgram.")
```

Test it:
```bash
myprogram goodbye
myprogram goodbye --name Alice
```

### Exercise 2: Add a Countdown Command

```python
@cli.command()
@click.option('--start', default=5, type=int, help='Number to count from')
def countdown(start):
    """Count down from a number."""
    import time
    for i in range(start, 0, -1):
        click.echo(f"{i}...")
        time.sleep(1)
    click.echo("Blast off! 🚀")
```

Test it:
```bash
myprogram countdown
myprogram countdown --start 3
```

### Exercise 3: Add a Calculator Command

```python
@cli.command()
@click.option('--a', type=float, required=True, help='First number')
@click.option('--b', type=float, required=True, help='Second number')
@click.option('--operation', type=click.Choice(['add', 'subtract', 'multiply', 'divide']), default='add')
def calc(a, b, operation):
    """Simple calculator."""
    if operation == 'add':
        result = a + b
    elif operation == 'subtract':
        result = a - b
    elif operation == 'multiply':
        result = a * b
    elif operation == 'divide':
        result = a / b if b != 0 else "Cannot divide by zero"
    
    click.echo(f"{a} {operation} {b} = {result}")
```

Test it:
```bash
myprogram calc --a 10 --b 5 --operation add
myprogram calc --a 10 --b 5 --operation multiply
```

---

## Part 8: Next Steps

Now that you understand the basics:

1. **Explore Click documentation**: https://click.palletsprojects.com/
2. **Modify the code**: Add your own commands and options
3. **Write tests**: Add tests for your new commands
4. **Read other projects**: Look at popular CLI tools on GitHub
5. **Build something**: Create your own CLI application!

---

## Quick Reference: Common Patterns

### Pattern 1: Command with Required Argument
```python
@cli.command()
@click.argument('filename')  # Required positional argument
def process(filename):
    """Process a file."""
    click.echo(f"Processing {filename}")
```

### Pattern 2: Command with Multiple Options
```python
@cli.command()
@click.option('--input', '-i', required=True)
@click.option('--output', '-o', default='output.txt')
@click.option('--verbose', '-v', is_flag=True)
def convert(input, output, verbose):
    """Convert files."""
    if verbose:
        click.echo(f"Converting {input} to {output}")
```

### Pattern 3: Command with Confirmation
```python
@cli.command()
@click.option('--force', is_flag=True)
def delete(force):
    """Delete something."""
    if not force:
        if not click.confirm('Are you sure?'):
            return
    click.echo("Deleted!")
```

---

## Troubleshooting

**Command not found after installing?**
- Make sure you ran `pip install -e .`
- Check `setup.py` has correct entry_points
- Try reopening your terminal

**Changes not taking effect?**
- With `-e` flag, Python changes take effect immediately
- If you changed setup.py, re-run `pip install -e .`

**Import errors?**
- Make sure you're in the right directory
- Check `__init__.py` exists in package folders
- Verify package is installed: `pip list | grep myprogram`

---

Happy coding! 🎉
