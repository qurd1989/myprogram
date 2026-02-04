"""Tests for the main module."""

from click.testing import CliRunner
from myprogram.main import cli


def test_greet_default():
    """Test the greet command with default name."""
    runner = CliRunner()
    result = runner.invoke(cli, ['greet'])
    assert result.exit_code == 0
    assert "Hello, World!" in result.output
    assert "Welcome to MyProgram" in result.output


def test_greet_custom_name():
    """Test the greet command with a custom name."""
    runner = CliRunner()
    result = runner.invoke(cli, ['greet', '--name', 'Alice'])
    assert result.exit_code == 0
    assert "Hello, Alice!" in result.output
    assert "Welcome to MyProgram" in result.output


def test_info_command():
    """Test the info command."""
    runner = CliRunner()
    result = runner.invoke(cli, ['info'])
    assert result.exit_code == 0
    assert "MyProgram v" in result.output
    assert "CLI application" in result.output


def test_version_option():
    """Test the --version option."""
    runner = CliRunner()
    result = runner.invoke(cli, ['--version'])
    assert result.exit_code == 0
    assert "0.1.0" in result.output


def test_help_option():
    """Test the --help option."""
    runner = CliRunner()
    result = runner.invoke(cli, ['--help'])
    assert result.exit_code == 0
    assert "MyProgram" in result.output
    assert "greet" in result.output
    assert "info" in result.output
