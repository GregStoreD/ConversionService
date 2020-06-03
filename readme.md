Part I

Create a service capable of serving the following endpoints:
For all of the below endpoints a log entry needs to be created for their execution duration.

/conversions/ktoc
The ktoc endpoint should produce an output amount in celsius when given an input amount in kelvin.

/conversions/ctok
The ctok endpoint should produce an output amount in kelvin when given an input amount in celsius.

/conversions/mtok
The mtok endpoint should produce, when given an input amount in miles, an output amount in kilometers.

/conversions/ktom
The ktom endpoint should produce, when given an input amount in kilometers, an output amount in miles.


Part II

Lotto - Generate bets from a File rewards wins

Read from a file then operate the roulette based on the bets made by players then display outcome

Bonus Question (optional) - Generate multiples bets from a File and records the number of wins p/player

The bonus question requires a bit more clearance  
It comes down to having the user place multiple bets in one draw.
Based on the fact all bets/data come from a single file, the assessment doesn't state 
if we could edit the file in order to have multiple bets e.g Greg 1, 3.0, 4, 7 (bet & amount multiple times). 
However if allowed, my solution although not perfect is more inclined to use that specific approach.

The other approach would be to set a specific amount for each player then subtract random number that will be smaller then the original amount associated with the player then repeat the process until the player's is depleted (rendered to 0). 

If we could get more clarity on that specific matter I would be able to complete the bonus Question fully.