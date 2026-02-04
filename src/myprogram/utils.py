"""
Utility functions for MyProgram.
"""


def format_greeting(name):
    """
    Format a greeting message for a given name.

    Args:
        name (str): The name to greet

    Returns:
        str: A formatted greeting message
    """
    return f"Hello, {name}! Welcome to MyProgram."


def validate_input(value, min_length=1, max_length=100):
    """
    Validate input string length.

    Args:
        value (str): The value to validate
        min_length (int): Minimum allowed length
        max_length (int): Maximum allowed length

    Returns:
        bool: True if valid, False otherwise
    """
    if not isinstance(value, str):
        return False
    return min_length <= len(value) <= max_length
