#!/usr/bin/env python3
"""
Main application module for MyProgram.

This module provides the main entry point and CLI interface for the application.
"""

import click
from myprogram import __version__
from myprogram.utils import format_greeting


@click.group()
@click.version_option(version=__version__)
def cli():
    """MyProgram - A simple Python application starter template."""
    pass


@cli.command()
@click.option('--name', default='World', help='Name to greet')
def greet(name):
    """Greet someone with a friendly message."""
    message = format_greeting(name)
    click.echo(message)
    return message


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


def main():
    """Main entry point for the application."""
    cli()


if __name__ == '__main__':
    main()
