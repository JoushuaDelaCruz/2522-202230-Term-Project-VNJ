package ca.bcit.comp2522.termproject.vnj.BackToNature.Character;

import java.io.File;

/**
 * Behaviours of a non-playable character.
 *
 * @version 2022
 * @author Joushua Dela Cruz
 */
public interface NonPlayableCharacter {
    /**
     * Talks.
     */
    void talk();

    /**
     * Reads a dialogue from input.
     *
     * @param file source file of the dialogue.
     */
    void getDialogue(File file);
}
