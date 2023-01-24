# Laboratory 12

## Compulsory

- [x] The input will be a .class file, located anywhere in the file system.
- [x] Load the specified class in memory, identifying dynamically its package.
- [x] Using reflection, extract as many information about the class (at least its methods).
- [x] Using reflection, invoke the static methods, with no arguments, annotated with @Test.

## Homework

- [x] The input may be a folder (containing .class files) or a .jar. You must explore it recursively.
- [x] Create the complete prototype, in the same manner as javap tool.
- [x] Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.
- [x] Print a statistics regarding the tests.

## Bonus


- [ ] Consider the case when the input files are .java files and compile the source code before analyzing them. (use Java Compiler, for example).
- [ ] Using additional annotations, implement non-functional tests over the methods in order to test their reliability and efficiency.
- [ ] Use a bytecode manipulation and analysis framework, such as ASM, BCEL or Javassist in order to extract the bytecode of the class, perform bytecode instrumentation (inject code in some method) and generate dynamically a class.

## Project Status

Project is: finished

## Acknowledgements

- This project was based on [these requirements](https://profs.info.uaic.ro/~acf/java/labs/lab_12.html).

