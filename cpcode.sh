#!/bin/bash
pbpaste | highlight -O rtf -S $1 --style=github | pbcopy