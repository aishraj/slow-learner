import string
import collections

def decrypt(cyphertext):
    values = ''
    keys = ''

    for i in range(ord('a'),ord('z')+1):
        keys += chr(i)
        j = i - ord('a')
        values += chr(ord('a') + (j + 2) % 26)

    transtable = string.maketrans(keys,values)
    return string.translate(cyphertext,transtable)


if __name__ == "__main__":
    mycyphertext = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr\'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj."
    print decrypt(mycyphertext)


