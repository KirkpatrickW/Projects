public interface ListInterface<T> {

    public void add(T newEntry);
    /*  Adds a new entry to the end of the list.
        Entries currently in the list are unaffected.
        The list's size is increased by 1.

        @param newEntry The object to be added as a new list entry.
     */

    public T remove(int position);
    /*  Removes the entry at the given position from the list.
        Entries originally at positions higher than the given position
        are at the next lower position within the list and the list's
        size is decreased by 1.

        @param position An integer that indicates the position of the
                        entry to be removed.

        @return A reference to the removed entry.

        @throws IndexOutOfBoundsException if either position < 1
                                          or position > getLength()
     */

    public T replace(int position, T newEntry);
    /*  Replaces the entry at the given position in this list

        @param position An integer that indicates the position of the
                        entry to be removed.
        @param newEntry The object to be added as a new entry.

        @return The original entry that was replaced.

        @throws IndexOutOfBoundsException if either position < 1
                                          or position > getLength()

     */

    public int getLength();
    /*  Gets the length of this list

        @return The integer number of entries in this list
     */

    public boolean isEmpty();
    /*  Check whether this list is empty.

        @return True if getLength() == 0, false otherwise;
     */
}