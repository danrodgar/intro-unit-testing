# Introduction to Unit Testing

This repository contains teaching examples for unit testing and test quality in Java.

## Execution Model

Examples are intended to be run manually during class or local practice.
Automatic CI execution, badge generation, and report publishing are disabled by default.

## Projects

### assertions
- Java assertions basics.

### calculatorExample
- JUnit Jupiter fundamentals.
- Maven + JaCoCo basics.

### PITExample
- Mutation testing with PIT (Pitest).
- Separate project to teach mutation testing after JUnit foundations.

### complexNumber
- Unit testing with Hamcrest + JUnit.

### CucumberTestExample
- BDD with Cucumber + JUnit Platform.
- UI-oriented steps with Selenium/Sikuli.

### EasyMockExample
- Interaction-based testing with EasyMock.

### MavenExamples/AppEx0
- Basic Maven + JUnit test structure.

### MockitoATM
- Mocking and behavior verification with Mockito.

### SeleniumTestExample
- Selenium WebDriver examples (opt-in execution).

### PlaywrightExample
- Modern browser automation with Playwright (opt-in execution).

### TDDExampleFactorial
- TDD-oriented incremental example.

## Recommended Local Commands

Run tests for a project:

```bash
cd code/<ProjectName>
mvn test
```

Run mutation testing:

```bash
cd code/PITExample
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

Build slides:

```bash
latexmk -pdf -interaction=nonstopmode slides.tex
```

## License

This repository is licensed under
Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0).

See `LICENSE` for details.

## PDF Release Policy

Generated PDFs (for example, `slides.pdf`) are ignored by default.

Only publish a PDF for major versions by committing it under `releases/`, for example:

```bash
mkdir -p releases
cp slides.pdf releases/slides-v2.0.pdf
git add releases/slides-v2.0.pdf
```
