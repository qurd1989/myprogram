# Quick Start Guide - Learning Path

Welcome! This document will guide you through learning about this CLI application and bootstrap concepts.

## 🎯 Your Learning Path

### Complete Beginner? Start Here!

**Time: 30 minutes**

1. **Read [CLI_GUIDE.md](CLI_GUIDE.md)** (15 min)
   - Learn what CLI applications are
   - Understand the Click framework basics
   - See how the code works

2. **Read [BOOTSTRAP_GUIDE.md](BOOTSTRAP_GUIDE.md)** (15 min)
   - Understand project structure
   - Learn about setup.py and requirements.txt
   - See why files are organized this way

### Want Hands-On Learning?

**Time: 1 hour**

1. **Follow [TUTORIAL.md](TUTORIAL.md)** (45 min)
   - Step-by-step code walkthrough
   - Hands-on exercises
   - Try modifying the code yourself

2. **Use [GLOSSARY.md](GLOSSARY.md)** as reference (ongoing)
   - Look up terms you don't understand
   - Quick reference while coding

---

## 📖 Reading Order by Goal

### Goal: "I want to understand what this project does"
1. Read: **CLI_GUIDE.md** → What is CLI?
2. Try: Run `myprogram --help`, `myprogram greet`
3. Read: **TUTORIAL.md** Part 1-2 → See the code in action

### Goal: "I want to understand the project structure"
1. Read: **BOOTSTRAP_GUIDE.md** → Why these files?
2. Look at: File structure in your editor
3. Read: **TUTORIAL.md** Part 6 → Understand setup.py

### Goal: "I want to modify or extend this code"
1. Read: **TUTORIAL.md** → Complete walkthrough
2. Try: Exercises in Part 7
3. Reference: **GLOSSARY.md** → Look up terms as needed

### Goal: "I need quick answers"
1. Use: **GLOSSARY.md** → Quick definitions
2. Use: **CLI_GUIDE.md** Common Questions section
3. Use: **BOOTSTRAP_GUIDE.md** Common Questions section

---

## 🚀 Hands-On Learning Track (Recommended!)

Follow this interactive path to learn by doing:

### Step 1: Setup (5 minutes)
```bash
# Make sure the app is installed
cd myprogram
pip install -e .

# Test it works
myprogram --help
myprogram greet
```

### Step 2: Explore Commands (10 minutes)
```bash
# Try different options
myprogram greet --name Alice
myprogram greet --name "Your Name"
myprogram info
myprogram --version
```

**Questions to think about:**
- How does `--name` work?
- Where does the version number come from?
- What happens if you don't provide `--name`?

**Find answers in:** CLI_GUIDE.md sections 3-4

### Step 3: Read the Code (20 minutes)

Open these files and read along with TUTORIAL.md:

1. `src/myprogram/__init__.py` → Where is version stored?
2. `src/myprogram/main.py` → How are commands defined?
3. `src/myprogram/utils.py` → What helper functions exist?

**Questions to think about:**
- What does `@click.command()` do?
- Why is code split into multiple files?
- How does `format_greeting()` work?

**Find answers in:** TUTORIAL.md Parts 1-4

### Step 4: Understand Structure (15 minutes)

Look at the project structure:
```bash
tree -L 2 -I '__pycache__|*.egg-info|.git'
```

**Questions to think about:**
- Why is code in `src/myprogram/` not at root?
- What's the purpose of `setup.py`?
- Why separate `requirements.txt` and `requirements-dev.txt`?

**Find answers in:** BOOTSTRAP_GUIDE.md sections 2-4

### Step 5: Try Exercises (30 minutes)

Do the exercises in TUTORIAL.md Part 7:
1. Add a goodbye command
2. Add a countdown command
3. Add a calculator command

**This teaches you:**
- How to add new commands
- How to use different types of options
- How CLI patterns work

### Step 6: Run Tests (10 minutes)

```bash
# Run the tests
pytest -v

# Run specific test
pytest tests/test_main.py::test_greet_default -v

# See what tests do
cat tests/test_main.py
```

**Questions to think about:**
- How do tests work?
- What does `CliRunner()` do?
- How can you test your new commands?

**Find answers in:** TUTORIAL.md Part 5

---

## 📚 Reference While Learning

Keep these sections open in browser tabs:

1. **CLI_GUIDE.md** → When you see Click decorators (`@click.something`)
2. **BOOTSTRAP_GUIDE.md** → When you see file organization questions
3. **GLOSSARY.md** → When you encounter unfamiliar terms
4. **TUTORIAL.md** → When you want to try something hands-on

---

## 🎓 After You Finish

You'll understand:
- ✅ What CLI applications are and why they're useful
- ✅ How the Click framework simplifies CLI development
- ✅ Why projects use this structure (src/, tests/, setup.py)
- ✅ How to add your own commands and features
- ✅ How to test CLI applications
- ✅ Professional Python project organization

Next steps:
1. Modify this project to do something you need
2. Create your own CLI tool from scratch
3. Explore other CLI tools on GitHub
4. Read the [Click documentation](https://click.palletsprojects.com/)

---

## 💡 Learning Tips

**Don't rush!** Understanding these concepts takes time.

**It's okay to not understand everything at once.**
- Start with CLI_GUIDE.md
- Come back to concepts that confuse you
- Try the hands-on exercises

**Learn by doing:**
- Type the commands yourself
- Modify the code
- Break things and fix them
- Add your own features

**Ask questions:**
- Google terms you don't understand
- Check the GLOSSARY.md
- Look at the "Common Questions" in each guide

**Take breaks:**
- This is a lot of new information
- Learning in chunks is more effective
- Practice what you learned before moving on

---

## 📝 Self-Assessment Checklist

After reading the guides, can you answer these?

### CLI Basics
- [ ] What does CLI stand for?
- [ ] What is the Click framework?
- [ ] What does `@click.command()` do?
- [ ] How do you add options to commands?
- [ ] What's the difference between options and arguments?

### Bootstrap Concepts
- [ ] Why use `src/` directory?
- [ ] What does `setup.py` do?
- [ ] What are `requirements.txt` files for?
- [ ] Why have separate test directory?
- [ ] What does `pip install -e .` do?

### Code Understanding
- [ ] Where is the version number stored?
- [ ] How are CLI commands defined?
- [ ] How do you add a new command?
- [ ] How are tests written?
- [ ] How does the `myprogram` command work?

**If you can answer most of these, you understand the concepts!**
**If not, review the relevant sections in the guides.**

---

## 🆘 Need Help?

**Stuck on a concept?**
1. Check GLOSSARY.md for term definitions
2. Read the "Common Questions" sections
3. Try the hands-on exercises in TUTORIAL.md

**Code not working?**
1. Check the "Troubleshooting" section in TUTORIAL.md
2. Make sure you ran `pip install -e .`
3. Verify you're in the right directory

**Want to learn more?**
- [Click Documentation](https://click.palletsprojects.com/)
- [Python Packaging Guide](https://packaging.python.org/)
- [Real Python Tutorials](https://realpython.com/)

---

## 🎉 Ready to Start?

Pick your path:
- **Quick overview?** → Start with CLI_GUIDE.md
- **Deep dive?** → Follow the Hands-On Learning Track above
- **Reference only?** → Jump to GLOSSARY.md

Happy learning! 🚀
