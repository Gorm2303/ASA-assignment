# Use the base Ubuntu image
FROM ubuntu:latest

# Set environment variables to non-interactive (this prevents some prompts)
ENV DEBIAN_FRONTEND=noninteractive

# Your other settings here, e.g.,
WORKDIR /app

# Install LaTeX packages without interaction
RUN apt-get update -q && \
  apt-get install -yq texlive texlive-xetex texlive-science && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/*

COPY ./latexUtils/compile.sh .
RUN sed -i 's/\r$//' compile.sh
RUN chmod +x compile.sh
ENTRYPOINT ["bash", "compile.sh"]
