WiN
===

WiN (Wireless Inter-Home Network) is designed to do what crowd-funding did for projects but for mobile networks. Uses of this could be in businesses to replace wired phone extensions, communications when cellular towers and the Internet is down or in place of a pager at a hospital. It could even be used to call your son to dinner! It doesn't require an Internet connection or traditional cellular coverage so it can be completely free.

###Where are you in development?
You can see everything and vote/comment at our public Trello here: https://trello.com/b/xTcyUVmY

###How do I use this as of now?
NOTE: This is still in super early development so expect everything to change.

**Sending a message**

To send a message run "python send.py" (or "python.exe send.py" on Windows) and fill out the target's username and the message.

**Receiving messages**

Run "python client.py" (or "python.exe client.py" on Windows).

###What do I need to run this?
**WiN for GNU/Linux**

WiN for GNU/Linux requires:
* Python 2.7
* Zenity

**WiN for Mac OS X**

WiN for Mac OS X requires:
* Python 2.7

**WiN for Windows**

WiN for Windows requires:
* Windows XP or later
* *Note: No install of python is required. WiN for Windows comes with a standalone version of Python 2.7.5 from http://www.orbitals.com/programs/pyexe.html*

**WiN for Android**

WiN for Android requires:
* A device that supports multicast (most devices released with android 3.0 or higher support this)
* Android 4.0 or higher

###Frequent problems
**I'm not getting messages!**

Check you are on the same WiFi network *and* the same subnet. Also check that your firewall is not blocking port 8946 and 1501.

**I get _____ error!**

Leave a bug report on this GitHub page.

**Windows tells me I need to allow python.exe to access the network!**

Allow it. This is required for WiN to communicate.

###How can I help
Currently the Android app requires the most work. You'll see a few //TODO comments in the code. If you could help do any of those it would be amazing.
