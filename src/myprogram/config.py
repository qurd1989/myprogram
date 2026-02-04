"""
Configuration management for MyProgram.
"""

import os
from pathlib import Path


class Config:
    """Application configuration class."""

    def __init__(self):
        self.app_name = "MyProgram"
        self.version = "0.1.0"
        self.debug = os.getenv("DEBUG", "false").lower() == "true"
        self.log_level = os.getenv("LOG_LEVEL", "INFO")

    def get_config_dir(self):
        """Get the configuration directory path."""
        home = Path.home()
        config_dir = home / ".myprogram"
        config_dir.mkdir(exist_ok=True)
        return config_dir

    def __repr__(self):
        return f"Config(app_name={self.app_name}, version={self.version}, debug={self.debug})"


# Default configuration instance
config = Config()
