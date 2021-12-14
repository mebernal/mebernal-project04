Project folder:
mebernal-project04/

doc/
    -Javadoc

src/queues/Jukebox.java
    - Class Jukebox manages three objects of type Queue<String>. The constructor reads the
      file with user's request for what the song to add to which playlist.
src/queues/Queue.java
    - Parameterized class Queue implements Iterable. Objects of type Queue manage items in a singly
      linked list where we can enqueue() from the front and dequeue() items from the end of the queue.
src/queues/MyTunes.java
    - Main application which contains main(). Creates an object of type MyTunes which simulates
      a playlist queue. Enqueues and dequeues SongEntry objects from each playlist.
      Simulates playing each song and finally checks the state of each playlist.

resources/inputFile03.txt
    - Additional use cases.
resources/RUN.txt
    - Console output of MyTunes, Jukebox, and Queue.

README.txt
    - Description of submitted files.