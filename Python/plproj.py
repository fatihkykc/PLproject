with open('weblog.csv') as weblog:
    lines = [line.split(' ') for line in weblog]

with open("sorted_weblog.txt", "w") as output:
    for line in sorted(lines, key= lambda x: x[1]):
        output.write('' .join(line))
weblog.close()

with open('sorted_weblog.txt') as weblog2:
    result ={}
    for i in weblog2:
        date = i.split(',')[1]
        date = date.split(':')[0]
        result[date] = {}
weblog2.close()
with open('sorted_weblog.txt') as weblog3:
    linenum = 1
    for j in weblog3:
        date = j.split(',')[1]
        date = date.split(':')[0]
        ip = j.split(',')[0]
        result[date][linenum]=ip
        linenum+=1
weblog3.close()

def getIP(date='30/Nov/2017'):
    l = []
    for i in sorted(result[date].keys())[-5:]:
        l.append(result[date][i])
    return l

print(getIP())
