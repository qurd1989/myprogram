"""Tests for utility functions."""

from myprogram.utils import format_greeting, validate_input


def test_format_greeting():
    """Test the format_greeting function."""
    assert format_greeting("World") == "Hello, World! Welcome to MyProgram."
    assert format_greeting("Alice") == "Hello, Alice! Welcome to MyProgram."
    assert format_greeting("Bob") == "Hello, Bob! Welcome to MyProgram."


def test_validate_input_valid():
    """Test validate_input with valid inputs."""
    assert validate_input("test") is True
    assert validate_input("a") is True
    assert validate_input("x" * 100) is True


def test_validate_input_invalid():
    """Test validate_input with invalid inputs."""
    assert validate_input("") is False
    assert validate_input("x" * 101) is False
    assert validate_input(123) is False
    assert validate_input(None) is False


def test_validate_input_custom_limits():
    """Test validate_input with custom length limits."""
    assert validate_input("test", min_length=3, max_length=10) is True
    assert validate_input("ab", min_length=3, max_length=10) is False
    assert validate_input("x" * 11, min_length=3, max_length=10) is False
