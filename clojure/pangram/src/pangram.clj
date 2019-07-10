(ns pangram)

(def alphabet-as-set
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn pangram?
      [string]
      (let [string-as-set (set (.toLowerCase string))]
           (every? string-as-set alphabet-as-set)))
