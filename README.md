# sdp-assignment5
<img width="2624" height="659" alt="image" src="https://github.com/user-attachments/assets/b820da05-920e-4ec8-80c4-717174778b9b" />

# Flight Reservation System - Strategy Pattern

Architecture Justification: Strategy vs. State & Template Method

**Why Strategy:**
In our flight booking domain, we have entire families of interchangeable pricing algorithms. The Strategy pattern lets us extract these algorithms into isolated classes, making them completely independent from the main booking context. This allows the system to choose, apply, then switch the exact algorithm at runtime via the Selector. Adding a new calculation method leaves existing code untouched, perfectly satisfying the Open/Closed Principle.

**Why not State:**
Despite structural similarities using composition, their intents differ vastly. The State pattern changes context behavior based on internal lifecycle transitions. In this system, Context classes lack transitioning states. A calculation strategy is simply passed from the outside to perform an isolated mathematical task, returning a result while the booking's internal state remains completely unchanged.

**Why not Template Method:**
Template Method relies heavily on inheritance. It defines a rigid algorithm skeleton within an abstract base class, forcing subclasses to override only specific steps. Here, the calculation algorithms differ fundamentally from each other completely rather than just in intermediate steps. Using Template Method would create tight coupling through static inheritance. Choosing Strategy leverages object composition at the interface level, allowing full implementation swapping on the fly.

## 3. Refactoring with Git history

*   **Before (Bad implementation with switch/if-else):** 6316217410540927e25b13510a44433d367731e8
*   **After (Clean implementation using Strategy):** 606e900c0ab9df4aa251aca80e84f047034eacd2

