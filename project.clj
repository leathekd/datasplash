(defproject datasplash "0.7.30"
  :description "Clojure API for a more dynamic Google Cloud Dataflow and (hopefully) Apache BEAM"
  :url "https://github.com/ngrunwald/datasplash"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.12.1"]
                 [org.clojure/math.combinatorics "0.3.0"]
                 [org.clojure/tools.logging "1.3.0"]

                 [com.cnuernber/charred "1.037"]
                 [clj-stacktrace "0.2.8"]
                 [clj-time "0.15.2"]

                 [com.taoensso/nippy "3.5.0"]

                 [org.apache.beam/beam-sdks-java-core "2.65.0"]
                 [org.apache.beam/beam-sdks-java-io-elasticsearch "2.65.0"]
                 [org.apache.beam/beam-sdks-java-io-kafka "2.65.0"]
                 [org.apache.beam/beam-runners-direct-java "2.65.0"]
                 [org.apache.beam/beam-runners-google-cloud-dataflow-java "2.65.0"]
                 [org.apache.beam/beam-runners-core-java "2.65.0"]
                 ;; org.apache.kafka/kafka-clients is required it in
                 ;; the kafka ns. Match the version provided by beam. See:
                 ;; https://mvnrepository.com/artifact/org.apache.beam/beam-sdks-java-io-kafka
                 [org.apache.kafka/kafka-clients "2.4.1"]
                 [superstring "3.2.1"]

                 ;; required as of beam 2.55.0
                 [junit/junit "4.13.2"]

                 ;; as of 2.64.0, beam is now compatibla with slf4j 2.x. See
                 ;; https://github.com/apache/beam/pull/33574
                 [org.slf4j/slf4j-api "2.0.17"]]
  :pedantic? false
  :target-path "target/%s/"
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:unchecked"]
  :deploy-repositories {"releases" {:url "https://repo.clojars.org"}}
  :profiles {:dev {:dependencies
                   [[com.oscaro/tools-io "0.3.41"]
                    ;; include compression libs for tests
                    ;;  zstd
                    [com.github.luben/zstd-jni "1.5.7-3"]
                    ;;  lzo & lzop
                    [io.airlift/aircompressor "2.0.2"]
                    [com.facebook.presto.hadoop/hadoop-apache2 "3.2.0-1"]
                    ;; compatible log implementation for local runs
                    [org.slf4j/slf4j-simple "2.0.17"]]
                   :plugins [[dev.weavejester/lein-cljfmt "0.13.1"]]}
             :test {:source-paths ["test"]
                    :aot :all}})
