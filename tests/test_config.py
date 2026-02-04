"""Tests for configuration module."""

from myprogram.config import Config


def test_config_defaults():
    """Test default configuration values."""
    config = Config()
    assert config.app_name == "MyProgram"
    assert config.version == "0.1.0"
    assert config.debug is False
    assert config.log_level == "INFO"


def test_config_debug_from_env(monkeypatch):
    """Test debug configuration from environment variable."""
    monkeypatch.setenv("DEBUG", "true")
    config = Config()
    assert config.debug is True


def test_config_log_level_from_env(monkeypatch):
    """Test log level configuration from environment variable."""
    monkeypatch.setenv("LOG_LEVEL", "DEBUG")
    config = Config()
    assert config.log_level == "DEBUG"


def test_get_config_dir():
    """Test get_config_dir method."""
    config = Config()
    config_dir = config.get_config_dir()
    assert config_dir.exists()
    assert config_dir.name == ".myprogram"


def test_config_repr():
    """Test config string representation."""
    config = Config()
    repr_str = repr(config)
    assert "Config(" in repr_str
    assert "app_name=MyProgram" in repr_str
    assert "version=0.1.0" in repr_str
