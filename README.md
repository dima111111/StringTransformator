# StringTransformator

Description:
------------
Java string parser. 
The input is a string of the form number [string].
The output is a string containing repeated substrings.
This program is work until user enter string "end".

Examples:
------------
Input: 3[xyz]4[xy]z
Output: xyzxyzxyzxyxyxyxyz

Limitations:
------------
- one repetition may contain another. For example: 2 [3 [x] y] = xxxyxxxy
- allowed input characters: latin letters, numbers and brackets []
- numbers only mean the number of repetitions
- brackets only to indicate repeated substrings
- the input string is always valid.
