#!/usr/bin/env python3
"""
Daily Programming Exercise
A simple program to practice coding daily
"""

from datetime import datetime


def main():
    """Main function for daily programming exercises"""
    print("Welcome to your daily programming session!")
    print("Today's date:", get_current_date())
    print("Let's code something amazing!")


def get_current_date():
    """Get the current date in a friendly format"""
    return datetime.now().strftime("%Y-%m-%d")


if __name__ == "__main__":
    main()
