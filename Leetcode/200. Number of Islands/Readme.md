Similar to floodfill.

Goto each unvisited '1' and touch all its corresponding 1 thus making those visited, which means those islands are already a part of already existing island and they cannot be a part of another island.
But we should not make those '1' unvisited when returning from the function calls otherwise one '1' will contribute to different island formation.
