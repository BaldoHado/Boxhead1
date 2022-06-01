# Boxhead1

![box](https://user-images.githubusercontent.com/48562217/171460664-b659f3fd-ca68-4ea1-b3e5-93d572b4d014.png)

<h1>Boxhead</h1>
<h3>A singleplayer, wave-based shooting game where the player must survive against mobs of zombies and devils by picking up different guns to defend themself. </h3> 

<h2> How the game works </h2>

<h3> Player, Player Movement </h3>
The player begins off with 100 health points, and can not increase this amount or regain health points throughout the game. The player moves at a faster speed than the zombies and devils, and movement can be controlled with WASD (W - up, A - left, S - down, D - right).

<h3> Rounds, Boundaries </h3>
<p>Round one begins with thirty zombies and one devil. Each additional round, thirty more zombies and one more devil is spawned, gradually increasing the difficulty of the game. The score increases by 100 for each zombie kill and 500 for each devil kill. The map surrounds the edges of the screen and the player cannot move outside of the boundaries. </p>

<h3> Guns, Boxes </h3>
There are seven different guns in the game: Pistol (default gun), Uzi, Rocket, Sniper, Railgun, Ak-47, and Shotgun. Guns can be fired by pressing the space key. If the player has multiple guns, guns can be rotated by pressing the , and . keys. Each gun has a different firing rate, amount of damage, firing distance, ammo, and chance to obtain the gun. The firing rate of each gun will be visually displayed so the player knows when a shot is ready to be fired. All guns can shoot through multiple targets at once with no decrease in damage. In addition, the player starts off with a pistol with 10,000 ammo. New guns can be obtained by stepping over red boxes. Red boxes can either give the player new weapons or refill ammo on previous weapons. Three red boxes are spawned at the beginning of the game and more red boxes can be obtained by killing devils. 

<h3> Zombies, Devils </h3>
The zombies and devils both follow the player around the map. They can only attack the player within melee range, both do the same amount of damage, move at the same speed, and have the same hitbox. However, zombies only have 100 health points, while devils have 200 health points. Zombies are a white/gray color, while devils are a red/black color. 

<h3> Technologies Used </h3>
We coded the project with Java and made use of JFrame, KeyListener, ImageIcon, and Graphics. These technologies were used to create the map of the game and allow for graphics to be displayed. KeyListener allowed us to implement player movement throughout the map and ImageIcon gave us the ability to use our images in the game. We used Adobe Illustator to create all of the graphics, most of them being based off the original game of Boxhead (no longer playable due to flash being unsupported). 

<h3> Challenges Faced </h3>
Gun hit detection: It was extremely difficult because initially, we made the images all different sizes, so the hit detection we coded was completely off. We had to redraw and resize all images so that we could code the hit detection all for the same size of image. Redrawing the images was hard because some ammo would look weird if stretched out.
Rocket Launcher: The rocket launcher is a gun much different from the other guns because it has the ability to blow up an area and inflict AOE damage. Instead of applying the hit detection we had for all the other guns to the rocket, we had to completely recode it. It was difficult because we had to form an imaginary rectangle and code the hit detection around that area. Also,  we had to make sure that the rocket didn’t damage any zombies as it travelled to the rectangle: it would only damage zombies in the rectangle. We practically had to nullify the previous code that damaged any zombies that were hit during the bullet’s travel. 
Devil: Initially we made two separate classes: zombies and devils. We started with a zombie ArrayList and a single devil object because we weren’t sure how the game would work yet. At the end, we realized we wanted multiple zombies as the rounds increased. However, all the code for the devil was coded for the single object. Instead of tediously replacing each devil code with a traversal of the new devil ArrayList, we merged the devil class as a child class of the parent Zombie class. This was also difficult because we now had devil objects in the zombie ArrayList so we had to add if statements for every traversal to make sure we weren’t changing the devil. 

<h3>How to Install and Run the Project</h3>
Make sure to have Java installed, and download the game file. Open it, and enjoyy!

<h3> Credits </h3>

Adam Ta - https://github.com/BaldoHado
Luke Zheng - https://github.com/Lux101

]
