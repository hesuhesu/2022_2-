import re

f = open('UNDHR.txt')

# ^\([0-9]+\) : 문자열에서 첫 단어가 (0), (1), (2), ---- (9) 인 거
for line in f: 
    line = line.rstrip()
    if re.search('^\([0-9]+\)', line):
        print(line) 
