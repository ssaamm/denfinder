# denfinder [![Build Status](https://travis-ci.org/ssaamm/denfinder.svg?branch=master)](https://travis-ci.org/ssaamm/denfinder)

A project that helps you find which neighborhood you should live in.

## Using API keys

This project reads API keys from [src/main/java/template/util/ApiKeys.java](https://github.com/ssaamm/denfinder/blob/master/src/main/java/template/util/ApiKeys.java). Notice that environment variables are used to keep the API keys themselves out of source control. In Eclipse, right click on ```Main.java``` -> Run As... -> Run Configurations -> Environment -> New... -> enter a key. Keep adding keys until you have them all added. Here's an example of how it might look:

<img src="http://i.imgur.com/Tp3aP6L.png" alt="Run configuration" width="400px">
