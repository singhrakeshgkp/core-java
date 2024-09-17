### CountDownLatch

<p>
we use countDownLatch if one threads requires to wait  for one or more threads to complete before it can continue processing.
It works on the latch principle, thread will wait until get is open, thread which calls countdownlatch.await() method will wait until count reaches to zero or its interrupted by other thread. 

for example refer ```CountDownLatchEx.java```
</p>
