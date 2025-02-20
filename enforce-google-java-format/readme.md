Having different Java formatting styles throughout your project can be frustrating. It complicates:
- Navigating through code in your IDE
- Reviewing merge requests from your peers

A good solution for a Java project is to add Git hooks along with:
- [spotless-maven-plugin](https://github.com/diffplug/spotless/blob/main/plugin-maven/README.md) to format the code
- [git-build-hook-maven-plugin](https://github.com/rudikershaw/git-build-hook) to install the look inside `.git/` folder