# PClassic 2014f

During this PClassic event, my team only managed to answer three questions correctly after four hours. This is horrible compared to our performance last year; in PClassic 2013f we answered 7 out of 8 total questions and won third place. Here are the factors which led to our downfall.

tl;dr: we utilized teamwork poorly and thus wasted hours implementing bogus solutions or solving misinterpreted problems.

## Shortcomings during the last PClassic

Last year, at PClassic 2013f, all three winning teams answered 7 questions and thus a tiebreaker was needed. To break the tie, the judges used the number of incorrect submissions against each team. This meant that, every time a team sent in a broken solution, it was penalized for it.

While the other two winning teams in PClassic 2013f had only a few incorrect submissions, our team had many. This was because we did not verify our solutions before submitting them, and thus often found that our implementations broke down for certain edge cases.

We were also plagued by our lack of mathematical knowledge. Whether it was number theory or geometry, we fell a bit short. Ultimately, this only slowed us down but did not stop us; we were able to either derive the math ourselves or brute force the solution efficiently.

The biggest issue can be easily overlooked: we did not utilize our team. I (Alex) wrote 100% of the code which we submitted; I read all of the problems myself; and, generally, I was responsible for coming up with my own test cases. Because of this, I sometimes overlooked issues in the code or edge cases to test.

## Strategy going into PClassic 2014f

Since I knew some problems would involve math, I set out to implement a ton of pre-built mathematical utilities. This included the math that I had to use at PClassic 2013f, and a bunch of other stuff that's come in handy over the years. This was the extent to my preparation.

I knew that a lack of test cases was my downfall last year. Thus, my teammates and I decided to distribute the work and have different people create test cases. Additionally&mdash;and optimistically&mdash;we decided to split up the work in order to better utilize the team structure.

## Why we did so poorly

### We used teamwork incorrectly

Teamwork would have been invaluable had we used it correctly. However, instead of having multiple people look at each problem, we had different people hastily reading different problems. As a result, I spent over half my time implementing bogus solutions or solving misinterpreted problems.

Even when two people worked on a problem, only one of those people read the problem's two-paragraph description. For the ["Concert"](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/TriangleOne/src/Concert.java) problem, this meant spending over an hour implementing the solution *upside-down*. As it turns out, the upside-down version of the problem is difficult to solve; thus, I spent the last hour of PClassic 2014f writing a complex solution that was completely unrelated to the actual question. In the last 15 minutes&mdash;after somebody else finally read the question&mdash;I attempted and failed to implement a solution to the real problem.

For another problem, I spent over 45 minutes implementing and "fixing" my teammates' [broken algorithm](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/PenguinLanding/src/APenguinJumpedOverTheMoon.java) for detecting whether a rectangle intersects with a circle. While doing so, I heard things like "dude, I swear I've thought about this&mdash;we found all the edge cases." I am rather confident that if all four of us had participated in that problem, we would have found the [correct solution](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/PenguinLanding2/src/APenguinJumpedOverTheMoon.java) the first time.

### My personal failures

While I do not see this failure as any individual's fault, I might be considered the orchestrator of our downfall. Ultimately, it came down to what I typed into my computer, and a lot of the time I did not validate what I was doing before I did it.

My most blatant shortcoming was my implementation of ["NestAndBreakfast"](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/NestAndBreakfast/src/NestAndBreakfast.java). My initial solution used recursion and led to a stack overflow for large datasets. Even though I did eventually catch this, my fixed solution was too slow (running in O(n^2) time). Only last night, after the contest, did I spend more time thinking about the problem. As a result, I quickly realized how to simplify it to O(n) time. Had I paid more attention to this problem, we would easily have gotten four questions correct instead of three.

## What went right?

The best example of a problem that went *right* was ["PenguinByNorthPenguin"](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/NorthPenguin/src/PenguinByNorthPenguin.java). I and another teammate both read this problem; we both thought about the solution; we both came up with test cases; and we both played an integral part in solving it. While he created test cases, I created an implementation. He helped me validate my code as I wrote it, and as a result we solved it quickly.

The first problem on which I worked, ["PenguinInfo"](https://github.com/unixpickle/PClassic-2014f/blob/master/pclassic-workspace/PenguinInfo/src/PenguinInfo.java), was by far the easiest. The solution took only 24 lines of code--amounting to about 10 or 20 minutes of my time. The same teammate who helped me with "PenguinByNorthPenguin" helped me test my solution for "PenguinInfo". As a result, we got this question correct on the first try.
