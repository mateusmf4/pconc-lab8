#!/bin/env python3

import random
import os

with open("/usr/share/dict/words", "r") as file:
    words = [x.strip() for x in file.readlines()]

nfiles=50
nlines_per_file=800
nwords_per_line=200
outputdir="dataset"

os.makedirs(outputdir, exist_ok=True)

for i in range(nfiles):
    with open(f"{outputdir}/file_{i}.txt", "w") as file:
        file.write("\n".join(" ".join(random.choices(words, k=nwords_per_line)) for _ in range(nlines_per_file)))