# xBib : a transformation language and tool for BibTeX
> xBib is a transformation language on top of BibTeX, which enables the user to transform a .bib file to a more uniform output.
****
## Table of contents
* [General Information](#general-information)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [List of transformations](#transformations)
* [Acknowledgements](#acknowledgements)
****

## General Information
This language and tool was created to solve some of the issues that come with handling references using BibTeX. 
This tool allows the user to create a more uniform BibTeX bibliography, and allows them to transform the output to their liking, on a large scale.

The language xBib reads the provided .xbib file, which describes the formatting and  transformations, and the tool can compile and execute the code to transform a .bib file.

- The full argumentation and explanation is written as part of my [research paper.](https://essay.utwente.nl/94379/1/visser_BA_eemcs.pdf)

## Features
The language and tool allow the user to:
- Write formatting and specific transformations to a file that can be stored and used repeatedly.
- Parse provided BibTeX files and apply any .xbib file to get the desired output.

****

## Setup
After downloading [xBib.jar](releases/xbib.jar), you can save this file at any preferred directory.
To run xBib, you simply execute `java -jar [xbib directory]`

## Usage
- The tool requires arguments in the form `xbib.jar [xBib file] [BibTeX file] [Output file] [Optional .aux file]`
- An .aux file can be provided if necessary, but will be ignored when the transformations don't use it.

**The user can also add a flag `--flag`**

There are three write modes for the tool:
- `--normal` : the default option
- `--silent` : executes the code without displaying any information
- `--debug` : provides extra information

A help menu can be displayed using `--help`

****

## Transformations

## Acknowledgements