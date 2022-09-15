from gtts import gTTS

text = ""

tts = gTTS(text = text, lang = 'en')
tts.save("hello.mp3")

## pip install gtts
