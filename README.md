# Solo Quest: You're Welcome
**`Quest giver: Courier Nightsong`**
>Back and forth, forth and back.  It never ends.  I don't even know what I'm taking back and forth anymore, I cannot say.  I cannot pronounce any of the words in any of the letters.  Can you help me translate these most recent letters?  I cannot offer much, but maybe if you have any letters that need delivering I can get them there ASAP!

## Objectives required to complete
This lab has us creating phonetic version of words.  It involves creating a class, using composition, and making objects to run the code. There is also practice for String manipulation to capture and compare String letters and create a brand new String.

Hawaiian words can be intimidating to try to pronounce.  Seeing a word such as `humuhumunukunukuapua'a` can be enough to scare somebody away from the language completely.  However, the language is actually quite simple as it only contains 12 characters; 5 vowels and 7 consonants.

Some of the sounds are pronounced differently depending on their position and the characters around them.  The [tables at the bottom](##special-tables) of this README outlines the pronunciation of the consonants (p, k, h, l, m, n, w) and the vowels (a, e, i, o, u).


### Objective 1 - Designing a Plan
Our design plan should outline the steps being accomplished in each method of our program.  The following sections will be examples of what is expected from us when it comes to the design plan.

```
main method:
    Step 1: List the major tasks (limit to no more than four or five tasks)
        if you have more than four or five tasks that is a good indicator that you should break out into another method
    Step 2: Decompose the design of each major step in the Step 1 design
    Step 3: Decompose remaining sections of the design in Step 2 to small enough section so they can be easily coded
        this might not be possible for ALL sections of part 2, but most math things or boolean expressions could be written
    Step 4: Combine design components from Steps 1, 2, 3, and 4
method X: (this would be an actual method name in the code)
    repeat the 4 steps from above
method Y: (this again would be an actual method name in the code)
    repeat the 4 steps from above
```

All the steps above are combined into one plan.  Step 4 means that you are combining all the other steps into a single plan.

### Objective 2 - Cloning
- Clone this project into IntelliJ
    - remember to place it into a correct folder

### Objective 3 - Getting a Build Badge
It is possible to check the passing of your code from within IntelliJ.  We can discuss how to do that at office hours if needed.

To get this badge you will need to go to GitHub and then get some code and paste that code into your README inside IntelliJ.

**On GitHub**
- Click on the "Actions" tab in the top section under your repo name
- Select the "GitHub Classroom Workflow" on the left-hand side
- Click on the "..." button that is next to the search bar on the page
    - Select "Create status badge" from the dropdown menu
- On the window the pops open
    - Branch choose "main" from the options
    - Event choose "push" from the options
    - Click the green "Copy" button at the bottom of this page

**In IntelliJ**
- Open the README.md file by double-clicking on it from the "Project Panel"
- Paste your badge code at the very top
    - Make a new space at the top and paste it above everything else

Each time we make a push to GitHub the badge will update to show "Error", "failing", "success" to let us know the status of our code against the unit tests written.

### Objective 4 - Branching from the main
- Click on the word "Git" in the bottom left corner of IntelliJ
    - Right-click on the word "main"
    - Choose "New branch from selected"
- On the popup name the branch `dev`
    - Leave the checkmark in "Checkout Branch"
    - Click "Create"

Now we have our `dev` branch, we double-check the bottom right corner it should say `dev`, not main.

We can now work on this `dev` branch.

## Quest Requirements
The bullet points in this section are the bare minimum needed.  There are often times where exact details are missing as it would give away the answer.  Therefore, we should realize that some more work and logic is required with certain steps.

### Objective 1 - HawaiianWord Class
We will need to create an appropriate class for this lab that will be used to represent a Hawaiian Word.

Create a class called `HawaiianWord`
- make the class in the following location (-> denotes going to a sub-folder)
- `src` -> `main` -> `java`
- This class should have at least one instance variable
    - The `word` which will be getting used
- Create two constructors for this class
    - one with no parameters
        - set the value of word to an appropriate default type
    - one with a single `String` parameter
        - set the instance field value to the passed value
- Create setters and getters for the instance field(s)
    - `setWord` and `getWord`
- Create a `createPhoneticVersion` method
    - return a phonetic version of the instance variable `word`
    - use the rules outlined above for phonetic spelling
        - if you are doing the phonetic spelling of a vowel place a `-` after the letters
    - You **MUST** iterate through the String to produce this output you are not allowed to use any type of replace method that the String class has.  You must also stay as a String and cannot convert yourself into a char array or any other type of collection.
    - if the word given is not a Hawaiian word meaning it contains consonants or vowels that are
      not part of the language then you should return the word unchanged
- Create a `countSyllables` method
  - return how many syllables are in a word
  - it should make a phonetic word first then count the syllables based on the phonetic word
  - we will say syllables are separated by the `-`s
    - for example: 
      - p-oh-le would return `3`
      - eh-gg would return `2`
    - if a word given does not have a phonetic spelling than it should return `1`
- Create a `toString` method
    - return a user-friendly version of the word
    - displayed in the following "Word: ZZ has a phonetic spelling of: XX"
        - the ZZ should be the word and the XX should be the phonetic spelling of the word

Plan out your algorithm with pencil and paper.  This is important because you are going to need to keep track of two values at once in certain parts.  This lab will require a loop to iterate over the word, there are multiple ways to do this as long as your logic is correct.

This lab requires a large number of conditional checks inside a loop.  Careful when attempting this with the {} make sure to keep track of where things are closing.  Your pseudocode will be invaluable at this part.

Remember when moving through the word sometimes you might have a `w` after an `i` or `e` changing its phonetic spelling.  This means you are always going to need to keep track of what comes before the current letter you are looking at.  This will require a `temp` variable that holds this letter.  If you find a W you then need to check if that `temp` variable is an `i` or `e` and if it is then make sure to use the `v` phonetic spelling instead of `w`.

Remember when moving through the word sometimes you might have vowel pairings.  This means you are always going to need to keep track of what comes after the current letter you are looking at.  This will require another `tempAfter` variable that holds this letter.  When checking the vowel check this second after letter variable to see what it might be.

If you are concatenating a String variable inside a loop use a StringBuilder instead.  StringBuilder has an `.append(varaible_name)` method, which takes an argument and will put that as the end of the StringBuilder.  This is more efficient when doing it inside a loop.  To return a String version of the StringBuilder you can call the `toString()` method on the StringBuilder object.

Some of your phonetic spellings may end with a `-` this should be removed.  Think about how you could check the last character in a String against this symbol.  How could you use String methods to go up to and ignore this symbol before returning.

### Objective 2 - MyWordTranslator Class
This class will be where our main method runs from.  It will also be used to create HawaiianWord objects and call the methods.

Create a class called `MyWordTranslator`
- make the class in the following location (-> denotes going to a sub-folder)
- `src` -> `main` -> `java`

### Objective 3 - Main method
We want to build a method that determines if the password the user guessed was correct.  As our game will interact with the user differently depending on this result we must get it right.

- Create a main method in this class
- Create a HawaiianWord object
- Ask the user for a word (the user for testing should enter a Hawaiian word and then a non Hawaiian word) to ensure the code works
- Take the user input word and convert it to a HawaiianWord calling the appropriate methods
- Print out the phonetic version of the user entered word

### Objective 4 - Merging to main branch and Pushing
- Click on the word "Git" in the bottom left corner of IntelliJ
- Select "main" (it should only say main)
    - Right-click and select "Checkout"
- It should now say "main" in the bottom right corner
- main should also have the checkout tag on it in this "Git" window
- Select the "dev" branch in this Git window
    - Right-click and select "Merge Selected into Current"
- Put a checkmark in the `dev` option
    - The checkmark might not be an option, if it is not that is acceptable
    - Only select the `dev` branch with no other words as this is our local version
- Click the merge button

### Objective 5 - Pushing back to GitHub
- Push all your commits to GitHub on both the main, dev, and any other branches you make
    - It does not hurt to do a final "add and commit" before pushing to verify the latest version is up on GitHub

The committing and pushing process does not change for different branches it is always the same.  If you are confused or struggling with this process please reach out and let me know.

**Note:** Only the code on the main branch will be graded.  It is important to make sure you are happy with your main branch.  You can check if you code is only GitHub by logging in, finding your repo based on the assignment and checking the commit messages on the page that loads.  This are in the middle column of the little box at the top.  You should see your most recent commit message next to whatever files/folder you pushed.

## Objective 6 - Video Walkthrough
Walk me through your code.  Explain to the best of your ability what is happening each line of code you have.  Being able to explain out your code is a helpful tool that re-enforces your learning of the material.

There are easy ways to do this:

- Screencast-O-Matic is installed on Chrome for Windows
- Mac's have built-in Quicktime Player, which has a menu option for screen recording
- Desktops around the room have Windows Key + G to bring up Game DVR

Whatever selection you choose make sure you are also capturing your microphone.

- Quicktime Player, drop-down next to the record button and select internal microphone
- Screencast-O-Matic again there is a menu option for microphone recording

You may need to grant access or permission to use the microphone.

If none of these options are easy for you to accomplish you can record via your cell phone.  However, you need to make sure I can clearly see the screen and the lines you are talking about along with hearing your explanations for the lines if using this method.

#### Grading
|   Points     |   Requirement                               |
| :----------: |:------------------------------------------- |
| 5            | documentation                               |
| 3            | instance variables correct                  |
| 5            | constructors correct (both of them)         |
| 3            | setters and getters correct                 |
| 3            | main method class made correctly            |
| 4            | HawaiianWord object made and methods called |
|10            | phonetic spelling method is correct return  |
| 7            | video walkthrough completed                 |


## Special Tables
**These tables are strictly meant to be helpful to you are your are completing your pseudocode and then if you need further reference or checking when programming.  You do not need to look at them when first reading this assignment.  Please wait until you are completing your pseudocode before referring to them**

### Consonants

|                      | |
| --------------------- |:-------------            |
| p, k, h, l, m, n      | pronounced like the English versions, which means use the letter in the phonetic spelling  |
| w - at start of a word   | either pronounced as a w or a v. pronounce as a w for this, it is `w` phonetically       |
| w - after the letter `a` | either pronounced as a w or v. pronounce as a w for this, it is `w` phonetically       |
| w - after `i` or `e`  | pronounced as a v sound, it is `v` phonetically              |
| w - after `u` or `o`  | sounds like w, it is `w` phonetically                         |

### Vowels
|                      | |
| --------------------- |:-------------    |
| a | sounds like `ah` eg. above - ah-bove |
| e | sounds like `eh` eg. egg - eh-gg     |
| i | sounds like `ee` eg. bee             |
| o | sounds like `oh` eg. pole - p-oh-le  |
| u | sounds like `oo` eg. mood - m-oo-d   |

### Vowel Groups

|                      | |
| --------------------- |:-------------     |
| ai | sounds like `eye` eg. ice            |
| ae | sounds like `eye` eg. ice            |
| ao | sounds like `ow` eg. how             |
| au | sounds like `ow` eg. how             |
| ei | sounds like `ay` eg. hay             |
| eu | sounds like `eh-oh`                  |
| iu | sounds like `ew` eg. curfew          |
| oi | sounds like `oy` eg. soy             |
| ou | sounds like `ow` eg. how             |
| ui | sounds like `ooey` eg. gooey         |
