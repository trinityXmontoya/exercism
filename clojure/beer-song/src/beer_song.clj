(ns beer-song
    (:require [clojure.string :as s]))

(defn verse
  "Returns the nth verse of the song."
  [num]
      (cond
        (= 0 num) "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall."
        (= 1 num) "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall."
        (= 2 num) "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall."
        :else  (str num " bottles of beer on the wall, " num " bottles of beer.\nTake one down and pass it around, " (dec num) " bottles of beer on the wall.")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
    (sing start 0))
  ([start end]
    (str (s/join "\n\n" (reverse (map verse (range end (inc start))))) "\n")))
