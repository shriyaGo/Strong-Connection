# Strong-Connection

**Problem Description:** \
We want to know the strong connection between two characters in a text based on how many times two characters are placed adjacent to each other in the input text.

Write a java function that accepts an input string text and returns the list of string representing the strongest connections between 2 characters.

**Function Signature -** \
ImmutableList<String> getStrongestConnection(String inputText);

**Sample Input-1** \
inputText - "String to check strong connection"

**Sample Output-1** \
["o <-> n : 3"]

**Sample Input-2** \
inputText - "String string to check multiple strong connections"

**Sample Output-2** \
["n <-> g : 3", "o <-> n : 3", "s <-> t : 3", "t <-> r : 3"]
