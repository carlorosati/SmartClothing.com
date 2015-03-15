OUTDIR=bin
SRCDIR=src
PKGNAME=gui
TARGET=Controller

# How to run:
# java -classpath $(OUTDIR) package.Classname

compile:
	mkdir -p $(OUTDIR)
	javac -d $(OUTDIR) -cp $(OUTDIR) -sourcepath $(SRCDIR) src/$(PKGNAME)/*.java

run: compile
	java -cp $(OUTDIR) $(PKGNAME).$(TARGET)

clean:
	rm -rf $(OUTDIR)