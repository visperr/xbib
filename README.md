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

- The full argumentation and explanation is written as part of my [research paper.](https://purl.utwente.nl/essays/94379)

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


### xBib syntax
An .xbib file is used to store certain transformations and formatting rules, that can later be applied to BibTeX files.

The transformations can be split up into **_categories_** and **_field actions_**. 

The three categories are:
- format
- order
- content

The user can define a category using the `go` command, followed by the specific category. This category can then
hold multiple transformations and rules that define it.

Inside of a category, a user is able to choose from three different tags:
- `[enable/disable] [flag]`
- `set [constant] to [value(s)]`
- `action [function] [arguments]`


_example code_:
```
go format (
    set indentation to (tab, 2),
    enable last_comma
);
go order (
    enable sort
);
go content (
    action change_type ('unpublished', 'article')
);
```

Lastly, field actions don't describe transformations for full entries, but change specific defined fields.

A field action requires one or multiple field names, followed by any actions that are applied.
```
field 'publisher' abbreviate;
field ('month','day') remove;
```

### Transformations
| Transformation key | Category | Type   | Arguments       | Description                                                    |
|:-------------------|----------|:-------|:----------------|:---------------------------------------------------------------|
| last_comma         | format   | flag   | enable/disable  | Last comma is shown or not.                                    |
| indentation        | format   | set    | tab/space , int | What, and how much indentation is used for each new line.      |
| string_identifier  | format   | set    | quotes/braces   | What symbol is used to define a string.                        |
| line_wrap          | format   | set    | int             | Line-wrap threshold.                                           |
| filter             | order    | action | array:word      | Show only entries specified by key.                            |`
| sort               | order    | flag   | enable/disable  | Sort entries alphabetically by key.                            |
| smart_filter       | order    | flag   | enable/disable  | Show only cited entries using provided .aux file.              |
| blind              | content  | action | array:word      | Blind specified entries, making them anonymous.                |
| rename_key         | content  | action | word , word     | Rename key.                                                    |
| change_type        | content  | action | word , word     | Change entry type.                                             |
| generate_keys      | content  | flag   | enable/disable  | Change every key based on the authors and year of publication. |
| abbreviate         | field    | action | array:word      | Try to abbreviate specified fields.                            |
| remove             | field    | action | array:word      | Remove any specified fields.                                   |
| capitalize         | field    | action | array:word      | Capitalize everything.                                         |
| lowercase          | field    | action | array:word      | Make everything lowercase.                                     |

## Acknowledgements
- This project is part of a research conducted at the University of Twente, Enschede, The Netherlands.
- This project was inspired by the work and research of [BibSLEIGH](http://grammarware.net/text/2017/bibsattose.pdf)