# What3WordsRest
Simple Java Project to request What3Words positions

Using the what3words API (http://developer.what3words.com/) this simple library can request a corrdinate response from a what3words grid value or vice versa

The What3WordsRequest class should be instatiated with an API Key and a base URL.  

The class exposes two main methods RequestW3W(string coords "lat,long") and a RequestPosition(string words e.g. "blah.blah.blah").

Includes jUnit tests.
