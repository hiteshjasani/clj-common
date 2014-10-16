(ns org.jasani.common)

(defn pff
  "Behave like printf should, but doesn't.

   Prints formatted text using *flush-on-newline* policy
   for buffer flushing."
  [fmt & args]
  (let [s (apply format fmt args)
        i (.indexOf s "\n")]
    (print s)
    (when (and (>= i 0)
               *flush-on-newline*)
      (flush))))

