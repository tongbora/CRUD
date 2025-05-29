#!/bin/bash

# Ask for commit message
echo "Enter your commit message:"
read commitMessage

# Check for uncommitted changes
if [[ -n $(git status -s) ]]; then
  git add .
  git commit -m "$commitMessage"
  git push
  echo "✅ Code pushed successfully!"
else
  echo "⚠️ No changes to commit."
fi
