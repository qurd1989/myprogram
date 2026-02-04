# MyProgram

A simple Python application starter template with CLI interface.

## Overview

MyProgram is a well-structured Python application template that provides a solid foundation for building command-line applications. It includes:

- Command-line interface using Click
- Modular project structure
- Configuration management
- Comprehensive test suite
- Easy installation and deployment

## Features

- **CLI Interface**: User-friendly command-line interface with multiple commands
- **Modular Design**: Clean separation of concerns with dedicated modules for utilities, configuration, and main application logic
- **Testing**: Full test coverage with pytest
- **Configuration**: Environment-based configuration management
- **Extensible**: Easy to add new commands and features

## Installation

### Prerequisites

- Python 3.8 or higher
- pip (Python package manager)

### Install from source

1. Clone the repository:
```bash
git clone https://github.com/qurd1989/myprogram.git
cd myprogram
```

2. Install the package:
```bash
pip install -e .
```

Or install with development dependencies:
```bash
pip install -e .
pip install -r requirements-dev.txt
```

## Usage

After installation, you can use the `myprogram` command:

### Greet Command

Greet someone with a friendly message:

```bash
# Greet the world (default)
myprogram greet

# Greet a specific person
myprogram greet --name Alice
```

### Info Command

Display information about the application:

```bash
myprogram info
```

### Help and Version

```bash
# Show help
myprogram --help

# Show version
myprogram --version
```

## Development

### Project Structure

```
myprogram/
├── src/
│   └── myprogram/
│       ├── __init__.py      # Package initialization
│       ├── main.py          # Main application and CLI
│       ├── config.py        # Configuration management
│       └── utils.py         # Utility functions
├── tests/
│   ├── __init__.py
│   ├── test_main.py         # Tests for main module
│   ├── test_config.py       # Tests for config module
│   └── test_utils.py        # Tests for utils module
├── setup.py                 # Package setup
├── requirements.txt         # Production dependencies
├── requirements-dev.txt     # Development dependencies
├── .gitignore              # Git ignore rules
└── README.md               # This file
```

### Running Tests

```bash
# Run all tests
pytest

# Run with coverage
pytest --cov=myprogram

# Run specific test file
pytest tests/test_main.py
```

### Code Quality

```bash
# Format code with black
black src/ tests/

# Check code style with flake8
flake8 src/ tests/
```

## Configuration

The application can be configured using environment variables:

- `DEBUG`: Set to "true" to enable debug mode (default: "false")
- `LOG_LEVEL`: Set logging level (default: "INFO")

Example:
```bash
DEBUG=true LOG_LEVEL=DEBUG myprogram greet --name Alice
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the MIT License.

## Author

Your Name - [GitHub](https://github.com/qurd1989)