vowels = ["a", "e", "i", "o", "u"]

while True:
    word = input()
    if word == "end": break

    flag = False
    cnt = ["a", 0]
    isVowel = ["v", 0]
    for w in word:
        # 모음 포함?
        if w in vowels:
            flag = True

            # 연속 3개?
            if isVowel[0] == "v":
                isVowel[1] += 1
            else:
                isVowel[0] = "v"
                isVowel[1] = 1
        else:
            if isVowel[0] == "c":
                isVowel[1] += 1
            else:
                isVowel[0] = "c"
                isVowel[1] = 1

        if isVowel[1] == 3:
            flag = False
            break

        # 두 번 연속?
        if cnt[0] == w:
            cnt[1] += 1
        else:
            cnt[0] = w
            cnt[1] = 1

        if cnt[0] != "e" and cnt[0] != "o" and cnt[1] == 2:
            flag = False
            break

    if not flag:
        print(f"<{word}> is not acceptable.")
        continue

    print(f"<{word}> is acceptable.")

