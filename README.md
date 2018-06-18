# JAS
Java port of [OpenAS, an automata simulation library](https://github.com/lvivtotoro/openas).

### What is this?
This library aims to create automata simulations quite quickly.
This is how one sets up Game of Life:
```java
RuleSetNeighbor<Integer> rules = new GOL();
DAutm<Integer> a = new DAutm<>(rules);

// set the world with a.set(x, y, 1);

a.step();  // step once
a.step(2); // step twice
```

### Is it fast?
heh, haha, *hah*, **HAAH_HAAAAH AHHHHHHHHHAAHA!!**!  
Actually, faster than the C++ implementation, somehow.

### License

You may use JAS and OpenAS under the terms of the Apache License 2.0.
